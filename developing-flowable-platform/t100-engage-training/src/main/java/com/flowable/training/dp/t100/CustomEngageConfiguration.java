package com.flowable.training.dp.t100;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.socket.messaging.DefaultSimpUserRegistry;

@Configuration
public class CustomEngageConfiguration {

    @Bean
    public SimpUserRegistry simpUserRegistry() {
        return new DefaultSimpUserRegistry();
    }

}
