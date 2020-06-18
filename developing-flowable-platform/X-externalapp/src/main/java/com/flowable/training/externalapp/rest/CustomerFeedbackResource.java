package com.flowable.training.externalapp.rest;

import com.flowable.training.externalapp.feedback.CustomerFeedback;
import com.flowable.training.externalapp.feedback.CustomerFeedbackService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/customer-feedback")
public class CustomerFeedbackResource {

    private final CustomerFeedbackService customerFeedbackService;

    public CustomerFeedbackResource(CustomerFeedbackService customerFeedbackService) {
        this.customerFeedbackService = customerFeedbackService;
    }

    /**
     * Sends the given customer feedback to the queue
     */
    @PostMapping
    public void sendCustomerFeedback(CustomerFeedback customerFeedback) {
        customerFeedbackService.sendCustomerFeedbackToQueue(customerFeedback);
    }

}
