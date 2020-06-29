package com.github.pettyfer.caas.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pettyfer.caas.system.entity.SystemGlobalConfiguration;
import com.github.pettyfer.caas.system.mapper.SystemGlobalConfigurationMapper;
import com.github.pettyfer.caas.system.service.ISystemGlobalConfigurationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Petty
 * @since 2020-06-29
 */
@Service
public class SystemGlobalConfigurationServiceImpl extends ServiceImpl<SystemGlobalConfigurationMapper, SystemGlobalConfiguration> implements ISystemGlobalConfigurationService {

    @Override
    public IPage<SystemGlobalConfiguration> page(SystemGlobalConfiguration systemGlobalConfiguration, Page<SystemGlobalConfiguration> page) {
        return this.page(page, Wrappers.lambdaQuery(systemGlobalConfiguration).orderByDesc(SystemGlobalConfiguration::getCreateTime));
    }

    @Override
    public SystemGlobalConfiguration get(String id) {
        return this.getById(id);
    }

    @Override
    public Boolean delete(String id) {
        return this.removeById(id);
    }

    @Override
    public String create(SystemGlobalConfiguration systemGlobalConfiguration) {
        systemGlobalConfiguration.setCreateTime(LocalDateTime.now());
        if (this.save(systemGlobalConfiguration)) {
            return systemGlobalConfiguration.getId();
        } else {
            throw new RuntimeException("新增失败");
        }
    }

    @Override
    public Boolean update(SystemGlobalConfiguration systemGlobalConfiguration) {
        systemGlobalConfiguration.setModifyTime(LocalDateTime.now());
        return this.updateById(systemGlobalConfiguration);
    }

}
