package com.hardworking.training.worker.init;

import ch.qos.logback.classic.joran.action.ConfigurationAction;
import com.amazonaws.services.sqs.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hardworking.training.worker.service.MessageService;
import com.hardworking.training.worker.service.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import java.io.IOException;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.hardworking.training.worker")
public class AppBootstrapConsumer {


    public static void main(String[] args) throws IOException {
       ConfigurableApplicationContext app= SpringApplication.run(AppBootstrapConsumer.class, args);
       MessageService messageService=app.getBean(MessageService.class);
        List<Message> messages=messageService.receiveMessage();
        for (Message m:messages){
            messageService.processMessage(m.getBody());
        }
    }
}
