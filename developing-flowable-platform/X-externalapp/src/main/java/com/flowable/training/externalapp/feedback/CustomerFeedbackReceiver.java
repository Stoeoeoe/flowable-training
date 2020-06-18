package com.flowable.training.externalapp.feedback;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerFeedbackReceiver {

    @JmsListener(destination = "customer-feedback")
    public void receiveMessage(CustomerFeedback feedback) {
        System.out.println("Received <" + feedback + ">");
    }

}
