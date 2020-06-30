package com.github.pettyfer.caas.engine.gitlab.service;


import com.github.pettyfer.caas.engine.gitlab.model.GitlabBranchView;
import com.github.pettyfer.caas.engine.gitlab.model.GitlabProjectView;
import com.github.pettyfer.caas.engine.gitlab.model.GitlabTagView;

import java.util.List;

/**
 * Gitlab项目信息查询
 * @author admin
 */
public interface IGitlabService {

    /**
     * 获取当前Gitlab用户下的全部项目
     * @return Project集合
     */
    List<GitlabProjectView> queryAllProjects();

    /**
     * 获取项目的全部分支
     * @return Branch集合
     */
    List<GitlabBranchView> queryProjectsBranchs();

    /**
     * 获取项目的全部Tag
     * @return Tag集合
     */
    List<GitlabTagView> queryProjectsTags();

}
