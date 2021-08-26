package com.ExcelWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class HandlingFormSubmissionApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
//        TypeWorkService typeWorkService = new TypeWorkService();
//        for (int i=0;i<10;i++){
//            TypeWork typeWork=new TypeWork();
//            typeWork.setName("Работа номер " + i);
//            typeWorkService.saveTypeWorkDao(typeWork);
//        }
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(HandlingFormSubmissionApplication.class, args);
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/templates/","classpath:/META-INF/resources/templates/","classpath:/resources/templates/"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

}