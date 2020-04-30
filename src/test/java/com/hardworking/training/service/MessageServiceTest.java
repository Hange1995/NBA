package com.hardworking.training.service;

import com.amazonaws.services.sqs.QueueUrlHandler;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.hardworking.training.init.AppBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;
    @Test
    public void sendMessageTest(){
        try{
            when(messageService.getQueueUrl(anyString())).thenReturn(String.valueOf(mock(GetQueueUrlResult.class)));
        }catch (Exception e){
            e.printStackTrace();
        }
        messageService.sendMessage("hello world ",1);
    }

}
