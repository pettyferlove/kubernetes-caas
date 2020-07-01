package com.github.pettyfer.caas.engine.docker.register.service.impl;

import com.github.pettyfer.caas.common.utils.ConverterUtil;
import com.github.pettyfer.caas.engine.docker.register.model.*;
import com.github.pettyfer.caas.engine.docker.register.service.IHarborService;
import com.github.pettyfer.caas.system.model.GlobalConfiguration;
import com.github.pettyfer.caas.system.service.ISystemGlobalConfigurationService;
import com.google.common.base.Preconditions;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Petty
 */
@Slf4j
@Service
public class HarborServiceImpl implements IHarborService {

    private final RestTemplate restTemplate;

    private final ISystemGlobalConfigurationService globalConfigurationService;

    public HarborServiceImpl(RestTemplate restTemplate, ISystemGlobalConfigurationService globalConfigurationService) {
        this.restTemplate = restTemplate;
        this.globalConfigurationService = globalConfigurationService;
    }

    @Override
    public List<RepositoryView> searchPublicRepository(String q) {
        GlobalConfiguration globalConfiguration = globalConfigurationService.loadConfig();
        Preconditions.checkNotNull(globalConfiguration.getDockerRegistryPath(), "未配置Harbor仓库地址");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("q", q);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<Search> responseEntity = restTemplate.exchange(globalConfiguration.getDockerRegistryPath() + Search.URL, HttpMethod.GET, requestEntity, Search.class);
        Search body = Optional.ofNullable(responseEntity.getBody()).orElseGet(Search::new);
        List<SearchRepository> repository = body.getRepository();
        return repository.stream().map(i -> {
            String pullPath = globalConfiguration.getDockerRegistryPath().replace("http://", "");
            String repositoryName = i.getRepositoryName();
            if (pullPath.endsWith("/")) {
                pullPath = pullPath + repositoryName;
            } else {
                pullPath = pullPath + "/" + repositoryName;
            }
            return RepositoryView.builder()
                    .projectId(i.getProjectId())
                    .projectName(i.getProjectName())
                    .projectPublic(i.getProjectPublic())
                    .pullCount(i.getPullCount())
                    .pullUrl(pullPath)
                    .repositoryName(i.getRepositoryName())
                    .tagsCount(i.getTagsCount())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
    public List<RepositoryTagView> queryRepositoryTag(String repoName) {
        GlobalConfiguration globalConfiguration = globalConfigurationService.loadConfig();
        Preconditions.checkNotNull(globalConfiguration.getDockerRegistryPath(), "未配置Harbor仓库地址");
        HttpHeaders headers = createAuthHeaders(globalConfiguration.getDockerRegistryUsername(), globalConfiguration.getDockerRegistryPassword());
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/json");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("detail", "false");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ParameterizedTypeReference parameterizedTypeReference = new ParameterizedTypeReference<List<DetailedTag>>() {};
        URI uri = new URI(globalConfiguration.getDockerRegistryPath() + MessageFormat.format(DetailedTag.URL, repoName));
        ResponseEntity<List<DetailedTag>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, parameterizedTypeReference);
        List<DetailedTag> body = Optional.ofNullable(responseEntity.getBody()).orElseGet(ArrayList::new);
        Optional<List<RepositoryTagView>> repositoryTagViews = Optional.ofNullable(ConverterUtil.convertList(DetailedTag.class, RepositoryTagView.class, body));
        return repositoryTagViews.orElseGet(ArrayList::new);
    }

    public static HttpHeaders createAuthHeaders(String username, String password) {
        return new HttpHeaders() {
            private static final long serialVersionUID = 2393630277970205061L;

            {
                String auth = username + ":" + password;
                String authHeader = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
                set("Authorization", authHeader);
            }
        };
    }

}
