package com.hardworking.training.service;

import com.hardworking.training.init.AppBootstrap;
import com.hardworking.training.model.Position;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppBootstrap.class)
public class PositionServiceTest {
    @Autowired PositionService positionService;
    private Position position = new Position();


}
