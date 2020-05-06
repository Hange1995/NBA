package com.hardworking.training.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Value("${aws.sqs}")
    private String queueName;
    @Autowired
    private AmazonSQS amazonSQS;
    public void sendMessage(String messageBody,int delay){
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(getQueueUrl(queueName))
                .withMessageBody(messageBody)
                .withDelaySeconds(delay);
        amazonSQS.sendMessage(send_msg_request);
    }

    public String getQueueUrl(String queueName){
        GetQueueUrlResult getQueueUrlResult=amazonSQS.getQueueUrl(queueName);
        return getQueueUrlResult.getQueueUrl();
    }

}
