package com.hardworking.training.worker.service;


import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.xspec.M;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MessageService {
//    @Value("${aws.sqs}")
    private String queueName="nba-hange";

    @Autowired
    private SendGridEmailService sendGridEmailService;

    @Autowired
    private AmazonSQS amazonSQS;


    public List<Message> receiveMessage() {
        return amazonSQS.receiveMessage(getQueueUrl(queueName)).getMessages();
    }



//    public void syncGetMessage() throws JMSException {
//        SQSConnectionFactory connectionFactory = new SQSConnectionFactory(
//                new ProviderConfiguration(),
//                AmazonSQSClientBuilder.standard()
//                        .withRegion("us-east-1")
//                        .withCredentials(new DefaultAWSCredentialsProviderChain()));
//        SQSConnection connection = connectionFactory.createConnection();
//        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
//        MessageConsumer consumer=session.createConsumer(session.createQueue(queueName));
//        connection.start();
//        receiveMessages(session,consumer);
//        connection.close();
//        System.out.println("Connection close");
//    }
//    private void receiveMessages(Session session,MessageConsumer messageConsumer){
//        try {
//            while (true){
//                System.out.println("Waiting for the messages");
//                javax.jms.Message message=messageConsumer.receive(TimeUnit.MINUTES.toMillis(1));
//                if (message==null){
//                    System.out.println("No message now, Continue waiting");
//                }
//                message.acknowledge();
//                System.out.println("Acknowledge message: "+ message.getJMSCorrelationID());
//            }
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
//    }



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



    @JmsListener(destination = "nba-hange")
    public void processMessage(String msg) throws IOException {
        Map<String, String> fakeRequest = new HashMap<>();
        fakeRequest.put("username", "SRC_USERNAME");
        fakeRequest.put("avatar", "AVATAR_URL");
        fakeRequest.put("attached_text", "ADDITIONAL_TEXT");
        fakeRequest.put("request_link", "REQUEST_LINK");

        Map<String, Object> fakeMessage = new HashMap<>();
        fakeMessage.put("subject", "Friend Invitation");
        fakeMessage.put("from", "hangechen9971@gmail.com");
        fakeMessage.put("to_emails", Arrays.asList("hangechen1995@gmail.com"));
        fakeMessage.put("to_usernames", Arrays.asList("Hange"));
        fakeMessage.put("request", fakeRequest);

        String fakeMessageJson = new ObjectMapper().writeValueAsString(fakeMessage);

        sendGridEmailService.sendEmail(fakeMessageJson);
    }

}
