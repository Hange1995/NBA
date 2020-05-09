package com.hardworking.training.worker.controller;

import com.amazonaws.services.sqs.model.Message;
import com.hardworking.training.worker.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import java.util.List;
@RestController
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Message> getMessages(){
        return messageService.receiveMessage();
    }



    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public boolean deleteMessages(){
        return  messageService.deleteMessage(messageService.receiveMessage());
    }


    @RequestMapping(value = "/sync")
    public void syncGetMessage(){
        try {
            messageService.syncGetMessage();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
