package com.klezovich.demo.components;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@Getter
@PropertySource("classpath:typeform.properties")
public class TypeformSettings {

    private final String baseUrl = "https://api.typeform.com/";

    @Value("${typeform.client-id}")
    private String clientId;

    @Value("${typeform.secret}")
    private String secret;

    @Value("${typeform.token}")
    private String token;


}
