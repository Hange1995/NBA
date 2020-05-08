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


    public boolean deleteMessage(List<Message> messages){
        int init = messages.size();
        int result=0;
        for (Message m : messages) {
            amazonSQS.deleteMessage(getQueueUrl(queueName), m.getReceiptHandle());
            result++;
        }
        return init==result;
    }

    public String getQueueUrl(String queueName) {
        GetQueueUrlResult getQueueUrlResult = amazonSQS.getQueueUrl(queueName);
        return getQueueUrlResult.getQueueUrl();
    }

}
