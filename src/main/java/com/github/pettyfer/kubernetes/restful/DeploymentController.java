package com.github.pettyfer.kubernetes.restful;

import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/deployment")
@Api(value = "Deployment Api", tags = {"Deployment Api"})
public class DeploymentController {

    private final KubernetesClient kubernetesClient;

    public DeploymentController(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @GetMapping("list")
    @ApiOperation(value = "查询Deployment列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "listOptions", value = "listOptions", dataTypeClass = ListOptions.class)
    })
    public DeploymentList list(ListOptions listOptions) {
        return kubernetesClient.apps().deployments().inNamespace("default").list(listOptions);
    }

}
