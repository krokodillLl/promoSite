package com.krokodillLl.promoSite.repos;

import com.krokodillLl.promoSite.domain.MainPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IMainPageRepo extends MongoRepository<MainPage, String> {
}
