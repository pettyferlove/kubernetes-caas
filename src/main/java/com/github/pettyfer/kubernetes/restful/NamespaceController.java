package com.github.pettyfer.kubernetes.restful;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/namespace")
public class NamespaceController {

    @PostMapping("{namespace}")
    @SneakyThrows
    public String create(@PathVariable String namespace) {
        return "success";
    }

    @DeleteMapping("{namespace}")
    @SneakyThrows
    public String delete(@PathVariable String namespace) {
        return "success";
    }

}
