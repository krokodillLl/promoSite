package com.krokodillLl.promoSite.controller;

import com.krokodillLl.promoSite.domain.ProjectsPage;
import com.krokodillLl.promoSite.domain.User;
import com.krokodillLl.promoSite.services.MainPageService;
import com.krokodillLl.promoSite.services.ProjectsPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectsController {
    private final static Logger logger = LoggerFactory.getLogger(ProjectsController.class);
    @Autowired
    ProjectsPageService projectsPageService;

    @GetMapping("/projects")
    public String getProjects(@AuthenticationPrincipal User user, Model model) {
        ProjectsPage projectsPage = projectsPageService.getProjectsPage();

        if(projectsPage != null) {
            model.addAttribute("html", projectsPage.getHtml());
        }
        else
            model.addAttribute("html", "empty");

        if(user != null) {
            model.addAttribute("button", "true");
        }
        else
            model.addAttribute("button", "false");

        return "projects";
    }
}
