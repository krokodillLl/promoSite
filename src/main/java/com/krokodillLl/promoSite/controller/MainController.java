package com.krokodillLl.promoSite.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/main")
    public String getMain(Model model) {

        return "main";
    }
}
