package com.github.pettyfer.caas.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pettyfer.caas.system.entity.SystemGlobalConfiguration;
import com.github.pettyfer.caas.system.model.GlobalConfiguration;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Petty
 * @since 2020-06-29
 */
public interface ISystemGlobalConfigurationService extends IService<SystemGlobalConfiguration> {
    /**
     * 获取当前用户的配置信息
     *
     * @return 对象
     */
    SystemGlobalConfiguration get();

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

    /**
     * 加载用户配置
     * @return GlobalConfiguration
     */
    GlobalConfiguration loadConfig();

}
