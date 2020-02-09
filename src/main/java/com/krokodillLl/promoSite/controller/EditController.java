package com.krokodillLl.promoSite.controller;

import com.krokodillLl.promoSite.domain.MainPage;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {
    private final Logger logger = LoggerFactory.getLogger(EditController.class);

    @Autowired
    MainPageService mainPageService;
    @Autowired
    ProjectsPageService projectsPageService;

    @GetMapping("/edit")
    public String getEdit(@AuthenticationPrincipal User user, Model model) {
        if (user == null)
            return "redirect:/main";
        else {
            if(mainPageService.getMainPage() != null && projectsPageService.getProjectsPage() != null) {
                model.addAttribute("mainHtml", mainPageService.getMainPage().getHtml());
                model.addAttribute("projectsHtml", projectsPageService.getProjectsPage().getHtml());
            }

            return "edit";
        }
    }

    @PostMapping("/edit")
    public void postEdit(@RequestParam String  newProjectsHtml, @RequestParam String newMainHtml){
        MainPage mainPage = mainPageService.getMainPage();
        if(mainPage == null) {
            mainPage = new MainPage();
        }
        if(mainPage.getHtml() != null && ! mainPage.getHtml().equals(newMainHtml)) {
            mainPage.setHtml(newMainHtml);
            mainPageService.saveMainPage(mainPage);
        }
        else if(mainPage.getHtml() == null) {
            mainPage.setHtml(newMainHtml);
            mainPageService.saveMainPage(mainPage);
        }

        ProjectsPage projectsPage = projectsPageService.getProjectsPage();
        if(projectsPage == null) {
            projectsPage = new ProjectsPage();
        }
        if(projectsPage.getHtml() != null && !projectsPage.getHtml().equals(newProjectsHtml)) {
            projectsPage.setHtml(newProjectsHtml);
            projectsPageService.saveProjectsPage(projectsPage);
        }
        else if(projectsPage.getHtml() == null) {
            projectsPage.setHtml(newProjectsHtml);
            projectsPageService.saveProjectsPage(projectsPage);
        }
    }
}
