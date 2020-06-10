package com.github.pettyfer.kubernetes.service.impl;

import com.github.pettyfer.kubernetes.domain.vo.ListQueryParams;
import com.github.pettyfer.kubernetes.domain.vo.NamespaceVO;
import com.github.pettyfer.kubernetes.domain.vo.Page;
import com.github.pettyfer.kubernetes.service.NamespaceService;
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NamespaceServiceImpl implements NamespaceService {

    private final KubernetesClient kubernetesClient;

    public NamespaceServiceImpl(KubernetesClient kubernetesClient) {
        this.kubernetesClient = kubernetesClient;
    }

    @Override
    public Page<NamespaceVO> listAll(ListQueryParams params) {
        return null;
    }

    @Override
    public Page<NamespaceVO> list(ListQueryParams params) {
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
