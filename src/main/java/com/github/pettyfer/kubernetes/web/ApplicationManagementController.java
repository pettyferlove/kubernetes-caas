package com.github.pettyfer.kubernetes.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("application-management")
public class ApplicationManagementController {

    @RequestMapping
    public String dashboard() {
        return "views/application-management";
    }

}
