package com.flowable.training.dp.t100;

import com.flowable.core.spring.security.SecurityUtils;
import com.flowable.policy.api.repository.PolicyRepositoryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {
    FreeMarkerAutoConfiguration.class
})
public class T100EngageApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(T100EngageApplication.class, args);
        PolicyRepositoryService policyRepositoryService;
    }
}

