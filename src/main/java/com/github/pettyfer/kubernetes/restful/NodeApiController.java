package com.github.pettyfer.kubernetes.restful;

import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/node")
@Api(value = "Node Api", tags = {"Node Api"})
public class NodeApiController {

    private final KubernetesClient kubernetesClient;

    public NodeApiController(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @GetMapping("list")
    @ApiOperation(value = "查询Node列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "listOptions", value = "listOptions", dataTypeClass = ListOptions.class)
    })
    public NodeList list(ListOptions listOptions) {
        return kubernetesClient.nodes().list(listOptions);
    }

    @GetMapping("{nodeName}")
    @ApiOperation(value = "获取Node详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "nodeName", value = "nodeName", dataTypeClass = String.class)
    })
    public Node get(@PathVariable String nodeName) {
        return kubernetesClient.nodes().withName(nodeName).get();
    }

}
