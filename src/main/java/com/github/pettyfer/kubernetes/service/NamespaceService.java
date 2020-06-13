package com.github.pettyfer.kubernetes.service;

import com.github.pettyfer.kubernetes.model.ListQueryParams;
import com.github.pettyfer.kubernetes.model.NamespaceView;
import com.github.pettyfer.kubernetes.model.Page;

public interface NamespaceService {

    Page<NamespaceView> listAll(ListQueryParams params);

    Page<NamespaceView> list(ListQueryParams params);

    Boolean create(String name);

    Boolean delete(String name);

}
