package com.github.pettyfer.kubernetes.service.impl;

import com.github.pettyfer.kubernetes.model.ListQueryParams;
import com.github.pettyfer.kubernetes.model.NamespaceView;
import com.github.pettyfer.kubernetes.model.Page;
import com.github.pettyfer.kubernetes.service.NamespaceService;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<NamespaceView> listAll(ListQueryParams params) {
        return null;
    }

    @Override
    public Page<NamespaceView> page(ListQueryParams params) {
        return null;
    }

    @Override
    public Boolean create(String name) {
        return null;
    }

    @Override
    public Boolean delete(String name) {
        return null;
    }
}
