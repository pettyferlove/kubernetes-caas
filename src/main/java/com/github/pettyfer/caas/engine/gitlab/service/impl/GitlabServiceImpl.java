package com.github.pettyfer.caas.engine.gitlab.service.impl;

import com.github.pettyfer.caas.common.utils.ConverterUtil;
import com.github.pettyfer.caas.engine.gitlab.model.GitlabBranchView;
import com.github.pettyfer.caas.engine.gitlab.model.GitlabProjectView;
import com.github.pettyfer.caas.engine.gitlab.model.GitlabTagView;
import com.github.pettyfer.caas.engine.gitlab.service.IGitlabService;
import com.github.pettyfer.caas.system.model.GlobalConfiguration;
import com.github.pettyfer.caas.system.service.ISystemGlobalConfigurationService;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabBranch;
import org.gitlab.api.models.GitlabProject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Petty
 */
@Slf4j
@Service
public class GitlabServiceImpl implements IGitlabService {

    private final ISystemGlobalConfigurationService globalConfigurationService;

    public GitlabServiceImpl(ISystemGlobalConfigurationService globalConfigurationService) {
        this.globalConfigurationService = globalConfigurationService;
    }

    @Override
    public List<GitlabProjectView> queryAllProjects() {
        /*GlobalConfiguration globalConfiguration = globalConfigurationService.loadConfig();
        Preconditions.checkNotNull(globalConfiguration.getGitlabHomePath(), "未配置Gitlab地址");
        Preconditions.checkNotNull(globalConfiguration.getGitlabApiToken(), "未配置Gitlab Api Token");;*/
        GitlabAPI connect = GitlabAPI.connect(globalConfiguration.getGitlabHomePath(), globalConfiguration.getGitlabApiToken());
        connect.getAllProjects()
        GitlabProject gitlabProject = new GitlabProject();
        System.out.println(ConverterUtil.convert(gitlabProject, new GitlabProjectView()));
        return new ArrayList<>();
    }

    @Override
    public List<GitlabBranchView> queryProjectsBranchs() {
        return null;
    }

    @Override
    public List<GitlabTagView> queryProjectsTags() {
        return null;
    }
}
