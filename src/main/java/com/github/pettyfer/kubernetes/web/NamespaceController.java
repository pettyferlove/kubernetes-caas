package com.github.pettyfer.kubernetes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("namespace")
public class NamespaceController {

    @RequestMapping
    public String dashboard() {
        return "views/namespace";
    }

}
