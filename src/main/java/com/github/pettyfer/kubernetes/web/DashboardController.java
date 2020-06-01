package com.github.pettyfer.kubernetes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class DashboardController {

    @RequestMapping
    public String dashboard() {
        return "views/dashboard";
    }

}
