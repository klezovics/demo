package com.klezovich.demo.controller;

import com.klezovich.demo.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService service;

    @GetMapping("/hello")
    public String getGreeting(Model m) {

        var greetingText = service.getRandomGreeting().getText();
        m.addAttribute("greeting", greetingText);

        return greetingText;
    }
}
