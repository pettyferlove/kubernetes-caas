package com.github.pettyfer.kubernetes.service;

import com.github.pettyfer.kubernetes.model.ListQueryParams;
import com.github.pettyfer.kubernetes.model.NamespaceView;
import com.github.pettyfer.kubernetes.model.Page;

import java.util.List;

/**
 * @author Petty
 */
public interface NamespaceService {

    /**
     * 列出所有的Namespace
     * @param params ListQueryParams
     * @return Page
     */
    List<NamespaceView> listAll(ListQueryParams params);

    /**
     * 列出当前用户（Kubernetes用户）下的所有的Namespace
     * @param params ListQueryParams
     * @return Page
     */
    Page<NamespaceView> page(ListQueryParams params);

    /**
     * 创建Namespace
     * @param name 名称
     * @return Boolean
     */
    Boolean create(String name);

    /**
     * 删除Namespace
     * @param name 名称
     * @return Boolean
     */
    Boolean delete(String name);

}
