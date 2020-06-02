package com.github.pettyfer.kubernetes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("continuous-integration")
public class ContinuousIntegrationController {

    @RequestMapping
    public String dashboard() {
        return "views/continuous-integration";
    }

}
