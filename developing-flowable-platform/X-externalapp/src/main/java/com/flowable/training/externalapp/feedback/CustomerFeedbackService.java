package com.flowable.training.externalapp.feedback;

import com.flowable.training.externalapp.constants.QueueConstants;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerFeedbackService {


    private final JmsTemplate jmsTemplate;


    public CustomerFeedbackService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    public void sendCustomerFeedbackToQueue(CustomerFeedback customerFeedback) {
        jmsTemplate.convertAndSend(QueueConstants.CUSTOMER_FEEDBACK_QUEUE, customerFeedback);
    }

}
