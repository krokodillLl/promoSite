package com.krokodillLl.promoSite.services;

import com.krokodillLl.promoSite.domain.MainPage;
import com.krokodillLl.promoSite.repos.IMainPageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainPageService {

    @Autowired
    private IMainPageRepo mainPageRepo;

    public void saveMainPage(final MainPage mainPage) {
        mainPageRepo.save(mainPage);
    }

    public MainPage getMainPage() {
        MainPage mainPage;
        List<MainPage> mainPageList = mainPageRepo.findAll();
        if(!mainPageList.isEmpty()) {
            mainPage = mainPageRepo.findAll().get(mainPageList.size() - 1);

            return mainPage;
        }
        else
            return null;
    }
}
