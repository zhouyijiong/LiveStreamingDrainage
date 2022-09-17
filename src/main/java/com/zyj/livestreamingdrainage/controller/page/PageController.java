package com.zyj.livestreamingdrainage.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    /**
     * 访问首页
     */
    @GetMapping
    public String index() {
        return "index/index";
    }
}