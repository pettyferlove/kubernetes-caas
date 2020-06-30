package com.github.pettyfer.caas.engine.kubernetes.restful;

import com.github.pettyfer.caas.engine.kubernetes.model.DeploymentPageView;
import com.github.pettyfer.caas.engine.kubernetes.model.ListQueryParams;
import com.github.pettyfer.caas.engine.kubernetes.model.Page;
import com.github.pettyfer.caas.common.model.R;
import com.github.pettyfer.caas.engine.kubernetes.service.DeploymentService;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/kubernetes/deployment")
@Api(value = "Deployment Api", tags = {"Deployment Api"})
public class DeploymentApiController {

    private final KubernetesClient kubernetesClient;

    private final DeploymentService deploymentService;

    public DeploymentApiController(KubernetesClient kubernetesClient, DeploymentService deploymentService) {
        this.kubernetesClient = kubernetesClient;
        this.deploymentService = deploymentService;
    }

    @GetMapping("all/page")
    @ApiOperation(value = "查询全部Deployment")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "params", value = "params", dataTypeClass = ListQueryParams.class)
    })
    public R<Page<DeploymentPageView>> pageAll(ListQueryParams params) {
        return new R<>(deploymentService.pageAll(params));
    }

    @GetMapping("{namespace}/page")
    @ApiOperation(value = "查询Deployment")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "namespace", value = "namespace", dataTypeClass = String.class),
            @ApiImplicitParam(paramType = "query", name = "params", value = "params", dataTypeClass = ListQueryParams.class)
    })
    public R<Page<DeploymentPageView>> page(@PathVariable String namespace, ListQueryParams params) {
        return new R<>(deploymentService.page(namespace, params));
    }


    @GetMapping("view")
    public ReplicaSetList view(){
        return kubernetesClient.apps().replicaSets().inNamespace("default").withLabel("k8s-app","nginx-k8s").list();
    }

}
