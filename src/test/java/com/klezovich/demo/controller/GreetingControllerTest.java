package com.klezovich.demo.controller;

import com.klezovich.demo.model.Greeting;
import com.klezovich.demo.service.GreetingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class GreetingControllerTest {

    private GreetingController controller;

    @Mock
    private GreetingService service;

    @Mock
    private Model model;

    @Before
    public void setup() {

        initMocks(this);
        controller = new GreetingController(service);
    }


    @Test
    public void getGreeting() {

        var expGreeting = "Hola";
        when(service.getRandomGreeting()).thenReturn(new Greeting(expGreeting));

        var greeting = controller.getGreeting(model);
        assertEquals(expGreeting, greeting);
        verify(service, times(1)).getRandomGreeting();
        verify(model, times(1)).addAttribute(eq("greeting"), anyString());
    }
}