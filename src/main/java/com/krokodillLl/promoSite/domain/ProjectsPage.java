package com.krokodillLl.promoSite.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class ProjectsPage {

    @Field
    private String html;

    public ProjectsPage() {}

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
