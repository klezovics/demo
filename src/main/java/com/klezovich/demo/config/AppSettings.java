package com.klezovich.demo.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Getter
public class AppSettings {

    private final String url;

    AppSettings( Mutable mutable ){
        this.url = mutable.getUrl();
    }

    @Component
    @Data
    @ConfigurationProperties(prefix="app")
    static class Mutable{

        private String url;
    }
}
