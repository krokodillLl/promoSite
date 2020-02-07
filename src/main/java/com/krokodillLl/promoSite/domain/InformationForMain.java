package com.krokodillLl.promoSite.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.awt.image.BufferedImage;
import java.util.Map;

@Document
public class InformationForMain {

    @Field
    private Map<String, String> text;
    @Field
    private Map<String, BufferedImage> images;

    public InformationForMain() {}

}
