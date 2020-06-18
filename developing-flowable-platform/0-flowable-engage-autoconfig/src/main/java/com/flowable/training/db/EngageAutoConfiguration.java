package com.flowable.training.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Import({ SecurityConfiguration.class, SecurityActuatorConfiguration.class })
public class EngageAutoConfiguration {


}
