package com.github.pettyfer.caas.engine.register.restful;

import com.github.pettyfer.caas.common.model.R;
import com.github.pettyfer.caas.engine.register.model.RepositoryTagView;
import com.github.pettyfer.caas.engine.register.model.RepositoryView;
import com.github.pettyfer.caas.engine.register.service.IHarborService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/docker/register/harbor")
@Api(value = "Harbor镜像仓库 Api", tags = {"Harbor镜像仓库 Api"})
public class HarborApiController {

    private final IHarborService harborService;

    public HarborApiController(IHarborService harborService) {
        this.harborService = harborService;
    }

    @ApiOperation(value = "搜索公开资源")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "q", value = "关键词", dataTypeClass = String.class),
    })
    @GetMapping("public/search")
    public R<List<RepositoryView>> searchPublicRepository(String q) {
        return new R<>(harborService.searchPublicRepository(q));
    }

    @ApiOperation(value = "查询镜像标签")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "repoName", value = "Repository Name", dataTypeClass = String.class)
    })
    @GetMapping("repository/{repoName}/tag")
    public R<List<RepositoryTagView>> queryRepositoryTag(@PathVariable String repoName) {
        return new R<>(harborService.queryRepositoryTag(repoName));
    }

}
