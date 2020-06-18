package com.flowable.design.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Filip Hrisafov
 */
@SpringBootApplication
public class FlowableDesignApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FlowableDesignApplication.class, args);
    }
}
