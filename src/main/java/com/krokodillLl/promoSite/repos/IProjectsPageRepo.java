package com.krokodillLl.promoSite.repos;

import com.krokodillLl.promoSite.domain.ProjectsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProjectsPageRepo extends MongoRepository<ProjectsPage, String> {
}
