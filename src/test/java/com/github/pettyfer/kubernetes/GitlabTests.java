package com.github.pettyfer.kubernetes;

import lombok.SneakyThrows;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.models.GitlabProject;
import org.gitlab.api.models.GitlabVersion;
import org.junit.jupiter.api.Test;

public class GitlabTests {

    @Test
    @SneakyThrows
    public void gitlabProjectsTest() {
        GitlabAPI connect = GitlabAPI.connect("http://gitlab.ggjs.sinobest.cn/", "sxynF2-S5_owPwGJh5su");
        GitlabProject liuyang03813 = connect.getProject("liuyang03813", "auto-build-examples");
    }

}
