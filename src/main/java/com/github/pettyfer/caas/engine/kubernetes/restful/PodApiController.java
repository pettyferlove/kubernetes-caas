package com.github.pettyfer.caas.engine.kubernetes.restful;

import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/kubernetes/pod")
public class PodApiController {

    private final KubernetesClient kubernetesClient;

    public PodApiController(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @GetMapping("list")
    @SneakyThrows
    public String list() {
        return "success";
    }

}
