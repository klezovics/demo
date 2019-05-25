package com.klezovich.demo.components.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@Profile("with-scheduling")
@EnableScheduling
public class SchedulingConfig {

    @Lazy
    @Bean
    public ConsoleWriter scheduleWritingToConsole(){
        return new ConsoleWriter();
    }

    @Slf4j
    static class ConsoleWriter{

        @Scheduled(fixedDelay = 1000)
        public void writeToConsole() {
            log.info("Hello from console writter ...");
        }
    }
}
