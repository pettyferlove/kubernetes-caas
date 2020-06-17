package com.github.pettyfer.kubernetes.restful;

import com.github.pettyfer.kubernetes.model.ListQueryParams;
import com.github.pettyfer.kubernetes.model.NamespacePageView;
import com.github.pettyfer.kubernetes.model.Page;
import com.github.pettyfer.kubernetes.service.NamespaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/namespace")
@Api(value = "Namespace Api", tags = {"Namespace Api"})
public class NamespaceApiController {

    private final NamespaceService namespaceService;

    public NamespaceApiController(NamespaceService namespaceService) {
        this.namespaceService = namespaceService;
    }

    @GetMapping("all/list")
    @ApiOperation(value = "查询全部Namespace")
    public List<NamespacePageView> listAll() {
        return namespaceService.listAll();
    }

    @GetMapping("page")
    @ApiOperation(value = "查询Namespace列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "params", value = "params", dataTypeClass = ListQueryParams.class)
    })
    public Page<NamespacePageView> page(ListQueryParams params) {
        return namespaceService.page(params);
    }

    @PostMapping("{namespace}")
    @ApiOperation(value = "创建Namespace")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "namespace", value = "namespace", dataTypeClass = String.class)
    })
    public Boolean create(@PathVariable String namespace) {
        return namespaceService.create(namespace);
    }

    @DeleteMapping("{namespace}")
    @ApiOperation(value = "删除Namespace")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "namespace", value = "namespace", dataTypeClass = String.class)
    })
    public Boolean delete(@PathVariable String namespace) {
        return namespaceService.delete(namespace);
    }

}
