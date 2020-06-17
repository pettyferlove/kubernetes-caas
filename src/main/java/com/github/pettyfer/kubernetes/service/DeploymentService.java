package com.github.pettyfer.kubernetes.service;

import com.github.pettyfer.kubernetes.model.DeploymentPageView;
import com.github.pettyfer.kubernetes.model.ListQueryParams;
import com.github.pettyfer.kubernetes.model.Page;

/**
 * @author Petty
 */
public interface DeploymentService {

    /**
     * 分页查询所有的Deployment
     * @param params ListQueryParams
     * @return Page
     */
    Page<DeploymentPageView> pageAll(ListQueryParams params);

    /**
     * 分页查询当前Namespace下的Deployment
     * @param namespace 命名空间名称
     * @param params ListQueryParams
     * @return Page
     */
    Page<DeploymentPageView> page(String namespace, ListQueryParams params);

}
