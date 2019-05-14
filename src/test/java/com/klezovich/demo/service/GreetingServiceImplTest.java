package com.klezovich.demo.service;

import com.klezovich.demo.model.Greeting;
import com.klezovich.demo.repository.GreetingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
public class GreetingServiceImplTest {

    GreetingService service;

    @Mock
    GreetingRepository repository;

    @Before
    public void setup() {
        initMocks(this);
        service = new GreetingServiceImpl(repository);
    }

    @Test
    public void getGreeting() {

        var expectedGreeting = "Hi";

        when(repository.getRandomGreeting()).thenReturn(new Greeting(expectedGreeting));
        var text = service.getRandomGreeting().getText();
        assertEquals(expectedGreeting, text);

        verify(repository,times(1)).getRandomGreeting();
    }

    @Test(expected = RuntimeException.class)
    public void when_ExceptionThrownByRepository_ItIsPropagated() {

        when(repository.getRandomGreeting()).thenThrow(RuntimeException.class);
        service.getRandomGreeting();
    }
}