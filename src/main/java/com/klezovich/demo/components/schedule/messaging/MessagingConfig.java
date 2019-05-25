package com.klezovich.demo.components.schedule.messaging;

import com.klezovich.demo.config.AppSettings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
@Profile("with-scheduling")
@RequiredArgsConstructor
public class MessagingConfig {
    private final AppSettings appSettings;

    @Bean
    public Client createClient() {
        var rest = new RestTemplate();
        rest.setUriTemplateHandler(new DefaultUriBuilderFactory(appSettings.getUrl()));
        return new Client(rest);
    }

    @Slf4j
    @RequiredArgsConstructor
    static class Client {
        private final RestTemplate rest;

        @Scheduled(fixedDelay = 1000)
        public void sendPing() {
            log.info("Ping sent...");
            rest.getForObject("/server", String.class);
        }
    }

    @RestController
    @Slf4j
    static class Server {
        @GetMapping("/server")
        public void ping() {
            log.info("Ping received...");
        }
    }
}
