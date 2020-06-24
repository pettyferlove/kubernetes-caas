package com.github.pettyfer.kubernetes;

import lombok.SneakyThrows;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabProject;
import org.gitlab.api.models.GitlabProjectHook;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class GitlabTests {

    private final String HOOKS_ENDPOINT = "http://192.168.51.67:8885/api/v1/hooks/gitlab/";

    @Test
    @SneakyThrows
    public void gitlabProjectsTest() {
        GitlabAPI connect = GitlabAPI.connect("http://gitlab.ggjs.sinobest.cn/", "sxynF2-S5_owPwGJh5su");
        GitlabProject project = connect.getProject("liuyang03813", "auto-build-examples");
        String projectHookUrl = HOOKS_ENDPOINT + project.getName();
        List<GitlabProjectHook> projectHooks = connect.getProjectHooks(project);
        List<GitlabProjectHook> collect = projectHooks.stream().filter(i -> projectHookUrl.equals(i.getUrl())).collect(Collectors.toList());
        if(!(collect.size() >0)){
            connect.addProjectHook(project, projectHookUrl);
        }
    }

}
