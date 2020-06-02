package com.github.pettyfer.kubernetes.restful;

import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.swagger.annotations.*;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/namespace")
@Api(value = "Namespace Api", tags = {"Namespace Api"})
public class NamespaceApiController {

    private final KubernetesClient kubernetesClient;

    public NamespaceApiController(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @GetMapping("list")
    @ApiOperation(value = "查询Namespace列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "listOptions", value = "listOptions", dataTypeClass = ListOptions.class)
    })
    public NamespaceList list(ListOptions listOptions) {
        return kubernetesClient.namespaces().list(listOptions);
    }

    @PostMapping("{namespace}")
    @ApiOperation(value = "创建Namespace")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "namespace", value = "namespace", dataTypeClass = String.class)
    })
    public Namespace create(@PathVariable String namespace) {
        Namespace ns = new NamespaceBuilder()
                .withApiVersion("v1")
                .withKind("Namespace")
                .withNewMetadata()
                .withName(namespace)
                .endMetadata()
                .build();
        return kubernetesClient.namespaces().create(ns);
    }

    @DeleteMapping("{namespace}")
    @ApiOperation(value = "删除Namespace")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "namespace", value = "namespace", dataTypeClass = String.class)
    })
    public Boolean delete(@PathVariable String namespace) {
        return kubernetesClient.namespaces().withName(namespace).delete();
    }

}
