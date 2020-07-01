package com.github.pettyfer.caas.engine.docker.register.service;


import com.github.pettyfer.caas.engine.docker.register.model.RepositoryTagView;
import com.github.pettyfer.caas.engine.docker.register.model.RepositoryView;

import java.util.List;

/**
 * @author Petty
 */
public interface IHarborService {

    /**
     * 查询公共仓库
     * @param q 查询关键词
     * @return RepositoryView 视图对象
     */
    List<RepositoryView> searchPublicRepository(String q);

    /**
     * 获取Repository Tag
     * @param repoName Repository名称
     * @return 集合
     */
    List<RepositoryTagView> queryRepositoryTag(String repoName);


}
