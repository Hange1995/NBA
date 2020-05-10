package com.hardworking.training.worker.service;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

import javax.jms.*;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class SyncMessageReceiver {
    public static void main(String[] args) throws JMSException, InterruptedException {
        SQSConnectionFactory connectionFactory = new SQSConnectionFactory(
                new ProviderConfiguration(),
                AmazonSQSClientBuilder.standard()
                        .withRegion("us-east-1")
                        .withCredentials(new DefaultAWSCredentialsProviderChain()));
        // Create the connection
        SQSConnection connection = connectionFactory.createConnection();
        // Create the session
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        MessageConsumer consumer = session.createConsumer( session.createQueue("nba-hange") );
    // Instantiate and set the message listener for the consumer.
        consumer.setMessageListener(new MyListener());

    // Start receiving incoming messages.
        connection.start();

    // Wait for 1 second. The listener onMessage() method will be invoked when a message is received.
        Thread.sleep(1000);

//        connection.start();
//
//        receiveMessages(session, consumer);
//
//        // Close the connection. This closes the session automatically
//        connection.close();
//        System.out.println( "Connection closed" );
    }
    private static void receiveMessages( Session session, MessageConsumer consumer ) {
        try {
            while( true ) {
                System.out.println( "Waiting for messages");
                // Wait 1 minute for a message
                Message message = consumer.receive(TimeUnit.MINUTES.toMillis(1));
                if( message == null ) {
                    System.out.println( "Shutting down after 1 minute of silence" );
                    break;
                }
                message.acknowledge();
                System.out.println( "Acknowledged message " + message.toString() );
            }
        } catch (JMSException e) {
            System.err.println( "Error receiving from SQS: " + e.getMessage() );
            e.printStackTrace();
        }
    }

}
