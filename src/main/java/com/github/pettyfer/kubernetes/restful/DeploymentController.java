package com.github.pettyfer.kubernetes.restful;

import com.github.pettyfer.kubernetes.domain.vo.DeploymentVO;
import com.github.pettyfer.kubernetes.domain.vo.ListQueryParams;
import com.github.pettyfer.kubernetes.domain.vo.Page;
import com.github.pettyfer.kubernetes.domain.vo.R;
import com.github.pettyfer.kubernetes.service.DeploymentService;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.apps.Deployment;
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
@RequestMapping("/api/v1/deployment")
@Api(value = "Deployment Api", tags = {"Deployment Api"})
public class DeploymentController {

    private final DeploymentService deploymentService;

    public DeploymentController(DeploymentService deploymentService) {
        this.deploymentService = deploymentService;
    }

    @GetMapping("all/list")
    @ApiOperation(value = "查询全部Deployment")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "params", value = "params", dataTypeClass = ListQueryParams.class)
    })
    public R<Page<DeploymentVO>> listAll(ListQueryParams params) {
        return new R<>(deploymentService.listAll(params));
    }

    @GetMapping("{namespace}/list")
    @ApiOperation(value = "查询Deployment")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "namespace", value = "namespace", dataTypeClass = String.class),
            @ApiImplicitParam(paramType = "query", name = "params", value = "params", dataTypeClass = ListQueryParams.class)
    })
    public R<Page<DeploymentVO>> list(@PathVariable String namespace, ListQueryParams params) {
        return new R<>(deploymentService.list(namespace, params));
    }

}
