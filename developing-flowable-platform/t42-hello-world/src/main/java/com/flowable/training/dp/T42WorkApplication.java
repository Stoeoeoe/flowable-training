package com.flowable.training.dp;

import com.flowable.audit.api.AuditService;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {
    FreeMarkerAutoConfiguration.class
})
public class T42WorkApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(T42WorkApplication.class, args);
    }

}
