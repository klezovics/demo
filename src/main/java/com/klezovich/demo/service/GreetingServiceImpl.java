package com.klezovich.demo.service;

import com.klezovich.demo.model.Greeting;
import com.klezovich.demo.repository.GreetingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository repository;

    @Override
    public Greeting getRandomGreeting() {

        return repository.getRandomGreeting();
    }
}
