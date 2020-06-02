package com.github.pettyfer.kubernetes.service.impl;

import com.github.pettyfer.kubernetes.service.DeploymentService;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Petty
 */
@Service
public class DeploymentServiceImpl implements DeploymentService {

    private final KubernetesClient kubernetesClient;

    public DeploymentServiceImpl(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @Override
    public List<Deployment> list() {
        DeploymentList list = kubernetesClient.apps().deployments().inAnyNamespace().list();
        return new ArrayList<>(list.getItems());
    }
}
