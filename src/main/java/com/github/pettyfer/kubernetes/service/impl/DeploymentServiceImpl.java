package com.github.pettyfer.kubernetes.service.impl;

import com.github.pettyfer.kubernetes.domain.vo.DeploymentVO;
import com.github.pettyfer.kubernetes.domain.vo.ListQueryParams;
import com.github.pettyfer.kubernetes.domain.vo.Page;
import com.github.pettyfer.kubernetes.service.DeploymentService;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Petty
 */
@Service
public class DeploymentServiceImpl implements DeploymentService {

    private final KubernetesClient kubernetesClient;

    public DeploymentServiceImpl(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @Override
    public Page<DeploymentVO> listAll(ListQueryParams params) {
        DeploymentList list = kubernetesClient.apps().deployments().inAnyNamespace().list();
        List<DeploymentVO> deployments = list.getItems().stream()
                .skip((params.getCurrentPage()-1)*params.getPageSize())
                .limit(params.getPageSize())
                .map(i->{
                    List<Container> containers = i.getSpec().getTemplate().getSpec().getContainers();
                    return DeploymentVO.builder()
                            .name(i.getMetadata().getName())
                            .imagesName(containers.get(0).getImage())
                            .namespace(i.getMetadata().getNamespace())
                            .creationTimestamp(i.getMetadata().getCreationTimestamp())
                            .groupStatus(i.getStatus().getReplicas()+ "/" + i.getStatus().getReadyReplicas())
                            .build();
                }).collect(Collectors.toList());
        Page<DeploymentVO> page = new Page<DeploymentVO>();
        page.setRecords(deployments);
        page.setCurrent(params.getCurrentPage());
        page.setSize(params.getPageSize());
        page.setTotal(list.getItems().size());
        return page;
    }

    @Override
    public Page<DeploymentVO> list(String namespace, ListQueryParams params) {
        DeploymentList list = kubernetesClient.apps().deployments().inNamespace(namespace).list();
        List<DeploymentVO> deployments = list.getItems().stream()
                .skip((params.getCurrentPage()-1) * params.getPageSize())
                .limit(params.getPageSize())
                .map(i->{
                    List<Container> containers = i.getSpec().getTemplate().getSpec().getContainers();
                    return DeploymentVO.builder()
                            .name(i.getMetadata().getName())
                            .imagesName(containers.get(0).getImage())
                            .namespace(i.getMetadata().getNamespace())
                            .creationTimestamp(i.getMetadata().getCreationTimestamp())
                            .groupStatus(i.getStatus().getReplicas()+ "/" + i.getStatus().getReadyReplicas())
                            .build();
                })
                .collect(Collectors.toList());
        Page<DeploymentVO> page = new Page<DeploymentVO>();
        page.setRecords(deployments);
        page.setCurrent(params.getCurrentPage());
        page.setSize(params.getPageSize());
        page.setTotal(list.getItems().size());
        return page;
    }
}
