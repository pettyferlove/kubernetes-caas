package com.github.pettyfer.kubernetes.service.impl;

import com.github.pettyfer.kubernetes.model.ListQueryParams;
import com.github.pettyfer.kubernetes.model.NamespaceView;
import com.github.pettyfer.kubernetes.model.Page;
import com.github.pettyfer.kubernetes.service.NamespaceService;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.NamespaceList;
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
public class NamespaceServiceImpl implements NamespaceService {

    private final KubernetesClient kubernetesClient;

    public NamespaceServiceImpl(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @Override
    public List<NamespaceView> listAll() {
        NamespaceList namespaceList = kubernetesClient.namespaces().list();
        return namespaceList.getItems().stream()
                .map(i -> NamespaceView.builder().name(i.getMetadata().getName()).build()).collect(Collectors.toList());
    }

    @Override
    public Page<NamespaceView> page(ListQueryParams params) {
        return null;
    }

    @Override
    public Boolean create(String namespace) {
        Namespace ns = new NamespaceBuilder()
                .withApiVersion("v1")
                .withKind("Namespace")
                .withNewMetadata()
                .withName(namespace)
                .endMetadata()
                .build();
        try {
            kubernetesClient.namespaces().create(ns);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Namespace创建失败，请检查是否存在重复名称");
        }
    }

    @Override
    public Boolean delete(String namespace) {
        try {
            return kubernetesClient.namespaces().withName(namespace).delete();
        } catch (Exception e) {
            throw new RuntimeException("Namespace删除失败，请检查是否存在");
        }
    }
}
