package com.github.pettyfer.kubernetes.restful;

import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1PodList;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/pod")
public class PodController {

    private final CoreV1Api coreV1Api;

    public PodController(CoreV1Api coreV1Api) {
        this.coreV1Api = coreV1Api;
    }

    @GetMapping("list")
    @SneakyThrows
    public V1PodList list() {
        return coreV1Api.listNamespacedPod("default", null, null, null, null, null, null,
                null, null, null);
    }

}
