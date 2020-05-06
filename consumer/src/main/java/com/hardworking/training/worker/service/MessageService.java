package com.hardworking.training.worker.service;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Value("${aws.sqs}")
    private String queueName;
    @Autowired
    private AmazonSQS amazonSQS;

    public List<Message> receiveMessage() {
        return amazonSQS.receiveMessage(getQueueUrl(queueName)).getMessages();
    }

    public String getQueueUrl(String queueName) {
        GetQueueUrlResult getQueueUrlResult = amazonSQS.getQueueUrl(queueName);
        return getQueueUrlResult.getQueueUrl();
    }

}
