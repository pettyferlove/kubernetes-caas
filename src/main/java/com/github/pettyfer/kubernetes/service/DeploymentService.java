package com.github.pettyfer.kubernetes.service;

import com.github.pettyfer.kubernetes.domain.vo.DeploymentVO;
import com.github.pettyfer.kubernetes.domain.vo.ListQueryParams;
import com.github.pettyfer.kubernetes.domain.vo.Page;
import io.fabric8.kubernetes.api.model.apps.Deployment;

/**
 * @author Petty
 */
public interface DeploymentService {

    Page<DeploymentVO> listAll(ListQueryParams params);

    Page<DeploymentVO> list(String namespace, ListQueryParams params);

}
