package com.github.pettyfer.kubernetes.service;

import com.github.pettyfer.kubernetes.domain.vo.ListQueryParams;
import com.github.pettyfer.kubernetes.domain.vo.NamespaceVO;
import com.github.pettyfer.kubernetes.domain.vo.Page;

public interface NamespaceService {

    Page<NamespaceVO> listAll(ListQueryParams params);

    Page<NamespaceVO> list(ListQueryParams params);

    Boolean create(String name);

    Boolean delete(String name);

}
