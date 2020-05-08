package com.hardworking.training.controller;

import com.hardworking.training.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String sendMessage(@RequestParam(name = "message") String messageBody, @RequestParam(name = "delay") int delay){
        messageService.sendMessage(messageBody,delay);
        return "Message: "+ messageBody+" send!";
    }
}
