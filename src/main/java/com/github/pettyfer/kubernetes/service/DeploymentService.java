package com.github.pettyfer.kubernetes.service;

import com.github.pettyfer.kubernetes.model.DeploymentView;
import com.github.pettyfer.kubernetes.model.ListQueryParams;
import com.github.pettyfer.kubernetes.model.Page;

/**
 * @author Petty
 */
public interface DeploymentService {

    Page<DeploymentView> listAll(ListQueryParams params);

    Page<DeploymentView> list(String namespace, ListQueryParams params);

}
