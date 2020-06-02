package com.github.pettyfer.kubernetes.restful;

import com.github.pettyfer.kubernetes.service.DeploymentService;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.api.model.apps.DoneableDeployment;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("list")
    @ApiOperation(value = "查询Deployment列表")
    public List<Deployment> list() {
        return deploymentService.list();
    }

}
