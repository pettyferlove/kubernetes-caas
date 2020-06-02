package com.github.pettyfer.kubernetes.restful;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Petty
 */
@RestController
@RequestMapping("/api/v1/pod")
public class PodApiController {
    @GetMapping("list")
    @SneakyThrows
    public String list() {
        return "success";
    }

}
