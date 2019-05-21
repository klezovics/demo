package com.klezovich.demo.components;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TypeformServiceTest {

    @Autowired
    TypeformService service;

    @Test
    public void correctEmailIsRetrieved(){

        var result = service.getMyEmail();
        assertEquals( "klezovich@gmail.com", result  );
    }

}