package com.github.pettyfer.caas.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pettyfer.caas.system.entity.SystemGlobalConfiguration;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Petty
 * @since 2020-06-29
 */
public interface ISystemGlobalConfigurationService extends IService<SystemGlobalConfiguration> {

    /**
     * List查找
     *
     * @param systemGlobalConfiguration 查询参数对象
     * @param page     Page分页对象
     * @return IPage 返回结果
     */
    IPage<SystemGlobalConfiguration> page(SystemGlobalConfiguration systemGlobalConfiguration, Page<SystemGlobalConfiguration> page);

    /**
     * 通过Id查询SystemGlobalConfiguration信息
     *
     * @param id 业务主键
     * @return 对象
     */
    SystemGlobalConfiguration get(String id);

     /**
      * 通过Id删除信息
      *
      * @param id 业务主键
      * @return Boolean
      */
     Boolean delete(String id);

     /**
      * 创建数据
      *
      * @param systemGlobalConfiguration 要创建的对象
      * @return Boolean
      */
     String create(SystemGlobalConfiguration systemGlobalConfiguration);

     /**
      * 更新数据（必须带Id）
      *
      * @param systemGlobalConfiguration 对象
      * @return Boolean
      */
     Boolean update(SystemGlobalConfiguration systemGlobalConfiguration);

}
