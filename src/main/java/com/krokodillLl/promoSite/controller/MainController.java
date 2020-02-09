package com.krokodillLl.promoSite.controller;

import com.krokodillLl.promoSite.domain.MainPage;
import com.krokodillLl.promoSite.domain.User;
import com.krokodillLl.promoSite.services.MainPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final static Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    MainPageService mainPageService;

    @GetMapping
    public String getRoot() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String getMain(@AuthenticationPrincipal User user, Model model) {
        MainPage mainPage = mainPageService.getMainPage();
        if(mainPage != null) {
            model.addAttribute("html", mainPage.getHtml());
        }
        else
            model.addAttribute("html", "empty");

        if(user != null) {
        model.addAttribute("button", "true");
    }
    else
        model.addAttribute("button", "false");


        return "main";
    }

    @GetMapping("/main/edit")
    public String getMainEdit(@AuthenticationPrincipal User user, Model model) {
        if(user != null) {
            model.addAttribute("button", "true");
        }
        else
            model.addAttribute("button", "false");

        return "main";
    }
}
