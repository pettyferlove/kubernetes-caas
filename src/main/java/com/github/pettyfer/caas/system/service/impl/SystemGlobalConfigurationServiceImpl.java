package com.github.pettyfer.caas.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
    public SystemGlobalConfiguration get() {
        LambdaQueryWrapper<SystemGlobalConfiguration> wrapper = Wrappers.<SystemGlobalConfiguration>lambdaQuery().eq(SystemGlobalConfiguration::getCreator, "default");
        return this.getOne(wrapper);
    }

    @Override
    public String create(SystemGlobalConfiguration systemGlobalConfiguration) {
        try {
            systemGlobalConfiguration.setCreator("default");
            systemGlobalConfiguration.setCreateTime(LocalDateTime.now());
            if (this.save(systemGlobalConfiguration)) {
                return systemGlobalConfiguration.getId();
            } else {
                throw new RuntimeException("新增失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("服务异常");
        }
    }

    @Override
    public Boolean update(SystemGlobalConfiguration systemGlobalConfiguration) {
        try {
            systemGlobalConfiguration.setModifier("default");
            systemGlobalConfiguration.setModifyTime(LocalDateTime.now());
            return this.updateById(systemGlobalConfiguration);
        } catch (Exception e) {
            throw new RuntimeException("服务异常");
        }
    }

}
