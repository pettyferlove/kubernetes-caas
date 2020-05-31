package com.github.pettyfer.kubernetes.controller;

import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1DeleteOptions;
import io.kubernetes.client.openapi.models.V1Namespace;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.openapi.models.V1Status;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/namespace")
public class NamespaceController {

    private final CoreV1Api coreV1Api;

    public NamespaceController(CoreV1Api coreV1Api) {
        this.coreV1Api = coreV1Api;
    }

    @PostMapping("{namespace}")
    @SneakyThrows
    public V1Namespace create(@PathVariable String namespace) {
        V1Namespace v1Namespace = new V1Namespace();
        v1Namespace.setKind("Namespace");
        v1Namespace.setApiVersion("v1");
        v1Namespace.setMetadata(new V1ObjectMeta().name(namespace));
        return coreV1Api.createNamespace(v1Namespace, null, null, null);
    }

    @DeleteMapping("{namespace}")
    @SneakyThrows
    public String delete(@PathVariable String namespace) {
        V1Namespace v1Namespace = new V1Namespace();
        v1Namespace.setKind("Namespace");
        v1Namespace.setApiVersion("v1");
        v1Namespace.setMetadata(new V1ObjectMeta().name(namespace));
        Integer gracePeriodSeconds = 0;
        Boolean orphanDependents = true;
        V1DeleteOptions options = new V1DeleteOptions();
        options.setApiVersion("v1");
        V1Status status = coreV1Api.deleteNamespace(namespace, null, null, gracePeriodSeconds, orphanDependents, null, options);
        System.out.println(status);
        return "success";
    }

}
