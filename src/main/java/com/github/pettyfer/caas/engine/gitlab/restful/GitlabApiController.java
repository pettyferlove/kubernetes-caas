package com.github.pettyfer.caas.engine.gitlab.restful;

import com.sinobest.caas.common.model.R;
import com.sinobest.caas.engine.gitlab.model.GitlabProjectView;
import com.sinobest.caas.engine.gitlab.service.IGitlabService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/gitlab")
@Api(value = "Gitlab Project Api", tags = {"Gitlab Project Api"})
public class GitlabApiController {

    private final IGitlabService gitlabService;

    public GitlabApiController(IGitlabService gitlabService) {
        this.gitlabService = gitlabService;
    }

    @ApiOperation(value = "查询全部Projects")
    @GetMapping("projects/all")
    public R<List<GitlabProjectView>> allProjects() {
        return new R<>(gitlabService.queryAllProjects());
    }

}
