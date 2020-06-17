package com.github.pettyfer.kubernetes.service;

import com.github.pettyfer.kubernetes.model.ListQueryParams;
import com.github.pettyfer.kubernetes.model.NamespaceDetailView;
import com.github.pettyfer.kubernetes.model.NamespacePageView;
import com.github.pettyfer.kubernetes.model.Page;

import java.util.List;

/**
 * @author Petty
 */
public interface NamespaceService {

    /**
     * 列出所有的Namespace
     * @return Page
     */
    List<NamespacePageView> listAll();

    /**
     * 列出当前用户（Kubernetes用户）下的所有的Namespace
     * @param params ListQueryParams
     * @return Page
     */
    Page<NamespacePageView> page(ListQueryParams params);

    /**
     * 创建Namespace
     * @param namespace 名称
     * @return Boolean
     */
    Boolean create(String namespace);

    /**
     * 删除Namespace
     * @param namespace 名称
     * @return Boolean
     */
    Boolean delete(String namespace);

    /**
     * 获取Namespace详情
     * @param namespace 名称
     * @return NamespaceDetailView
     */
    NamespaceDetailView get(String namespace);

}
