package com.github.pettyfer.kubernetes.service;

import com.github.pettyfer.kubernetes.domain.vo.ListQueryParams;
import com.github.pettyfer.kubernetes.domain.vo.Page;
import io.fabric8.kubernetes.api.model.apps.Deployment;

/**
 * @author Petty
 */
public interface DeploymentService {

    Page<Deployment> listAll(ListQueryParams params);

    Page<Deployment> list(String namespace, ListQueryParams params);

}
