package com.hardworking.training.repository;

import com.hardworking.training.init.AppBootstrap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class ABCTest {

    @Test
    public void test(){
        Assert.assertEquals(1,1);
    }
}
