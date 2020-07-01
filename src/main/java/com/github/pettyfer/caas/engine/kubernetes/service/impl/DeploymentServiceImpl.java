package com.github.pettyfer.caas.engine.kubernetes.service.impl;

import com.github.pettyfer.caas.engine.kubernetes.model.DeploymentPageView;
import com.github.pettyfer.caas.engine.kubernetes.model.ListQueryParams;
import com.github.pettyfer.caas.common.model.Page;
import com.github.pettyfer.caas.engine.kubernetes.service.DeploymentService;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Petty
 */
@Slf4j
@Service
public class DeploymentServiceImpl implements DeploymentService {

    private final KubernetesClient kubernetesClient;

    public DeploymentServiceImpl(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @Override
    public Page<DeploymentPageView> pageAll(ListQueryParams params) {
        DeploymentList list = kubernetesClient.apps().deployments().inAnyNamespace().list();
        List<DeploymentPageView> deployments = list.getItems().stream()
                .skip((params.getCurrentPage()-1)*params.getPageSize())
                .limit(params.getPageSize())
                .map(i->{
                    List<Container> containers = i.getSpec().getTemplate().getSpec().getContainers();
                    return DeploymentPageView.builder()
                            .name(i.getMetadata().getName())
                            .imagesName(containers.get(0).getImage())
                            .namespace(i.getMetadata().getNamespace())
                            .creationTimestamp(i.getMetadata().getCreationTimestamp())
                            .groupStatus(i.getStatus().getReplicas()+ "/" + i.getStatus().getReadyReplicas())
                            .build();
                }).collect(Collectors.toList());
        Page<DeploymentPageView> page = new Page<DeploymentPageView>();
        page.setRecords(deployments);
        page.setCurrent(params.getCurrentPage());
        page.setSize(params.getPageSize());
        page.setTotal(list.getItems().size());
        return page;
    }

    @Override
    public Page<DeploymentPageView> page(String namespace, ListQueryParams params) {
        DeploymentList list = kubernetesClient.apps().deployments().inNamespace(namespace).list();
        List<DeploymentPageView> deployments = list.getItems().stream()
                .skip((params.getCurrentPage()-1) * params.getPageSize())
                .limit(params.getPageSize())
                .map(i->{
                    List<Container> containers = i.getSpec().getTemplate().getSpec().getContainers();
                    return DeploymentPageView.builder()
                            .name(i.getMetadata().getName())
                            .imagesName(containers.get(0).getImage())
                            .namespace(i.getMetadata().getNamespace())
                            .creationTimestamp(i.getMetadata().getCreationTimestamp())
                            .groupStatus(i.getStatus().getReplicas()+ "/" + i.getStatus().getReadyReplicas())
                            .build();
                })
                .collect(Collectors.toList());
        Page<DeploymentPageView> page = new Page<DeploymentPageView>();
        page.setRecords(deployments);
        page.setCurrent(params.getCurrentPage());
        page.setSize(params.getPageSize());
        page.setTotal(list.getItems().size());
        return page;
    }
}
