package com.github.pettyfer.caas.system.restful;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pettyfer.caas.common.model.R;
import com.github.pettyfer.caas.system.entity.SystemGlobalConfiguration;
import com.github.pettyfer.caas.system.service.ISystemGlobalConfigurationService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  接口控制器
 * </p>
 *
 * @author Petty
 * @since 2020-06-29
 */
@Api(value = "", tags = {"接口"})
@RestController
@RequestMapping("/systemGlobalConfiguration")
public class GlobalConfigurationApiController {
    private final ISystemGlobalConfigurationService systemGlobalConfigurationService;

    public GlobalConfigurationApiController(ISystemGlobalConfigurationService systemGlobalConfigurationService) {
        this.systemGlobalConfigurationService = systemGlobalConfigurationService;
    }

    @ApiOperation(value = "获取列表", notes = "无需特殊权限", authorizations = @Authorization(value = "oauth2"))
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "systemGlobalConfiguration", value = "systemGlobalConfiguration", dataTypeClass = SystemGlobalConfiguration.class),
            @ApiImplicitParam(paramType = "query", name = "page", value = "Page", dataTypeClass = Page.class)
    })
    @GetMapping("page")
    public R<IPage> page(SystemGlobalConfiguration systemGlobalConfiguration, Page<SystemGlobalConfiguration> page) {
        return new R<>(systemGlobalConfigurationService.page(systemGlobalConfiguration, page));
    }


    @ApiOperation(value = "获取详情", notes = "无需特殊权限", authorizations = @Authorization(value = "oauth2"))
            @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "id", value = "id", dataTypeClass = String.class)
    })
    @GetMapping("/{id}")
    public R<SystemGlobalConfiguration> get(@PathVariable String id) {
        return new R<>(systemGlobalConfigurationService.get(id));
    }

    @ApiOperation(value = "创建", notes = "无需特殊权限", authorizations = @Authorization(value = "oauth2"))
            @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "systemGlobalConfiguration", value = "systemGlobalConfiguration", dataTypeClass = SystemGlobalConfiguration.class)
    })
    @PostMapping
    public R<String> create(SystemGlobalConfiguration systemGlobalConfiguration) {
        return new R<>(systemGlobalConfigurationService.create(systemGlobalConfiguration));
    }

    @ApiOperation(value = "更新", notes = "无需特殊权限", authorizations = @Authorization(value = "oauth2"))
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "systemGlobalConfiguration", value = "systemGlobalConfiguration", dataTypeClass = SystemGlobalConfiguration.class)
    })
    @PutMapping
    public R<Boolean> update(SystemGlobalConfiguration systemGlobalConfiguration) {
        return new R<>(systemGlobalConfigurationService.update(systemGlobalConfiguration));
    }

    @ApiOperation(value = "删除", notes = "无需特殊权限", authorizations = @Authorization(value = "oauth2"))
    @ApiImplicitParams({
    @ApiImplicitParam(paramType = "path", name = "id", value = "id", dataTypeClass = String.class)
    })
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable String id) {
        return new R<>(systemGlobalConfigurationService.delete(id));
    }
}
