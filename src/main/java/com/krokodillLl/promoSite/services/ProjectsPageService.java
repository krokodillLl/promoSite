package com.krokodillLl.promoSite.services;

import com.krokodillLl.promoSite.domain.ProjectsPage;
import com.krokodillLl.promoSite.repos.IProjectsPageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsPageService {

    @Autowired
    private IProjectsPageRepo projectsPageRepo;

    public void saveProjectsPage(final ProjectsPage projectsPage) {
        projectsPageRepo.save(projectsPage);
    }

    public ProjectsPage getProjectsPage() {

        ProjectsPage projectsPage;
        List<ProjectsPage> projectsPageList = projectsPageRepo.findAll();
        if(!projectsPageList.isEmpty()) {
            projectsPage = projectsPageRepo.findAll().get(projectsPageList.size() - 1);

            return projectsPage;
        }
        else
            return null;
    }
}
