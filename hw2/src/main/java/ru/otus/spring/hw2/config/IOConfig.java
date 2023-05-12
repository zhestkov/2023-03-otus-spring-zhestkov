package ru.otus.spring.hw2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.hw2.service.IOService;
import ru.otus.spring.hw2.service.IOServiceStreams;

@Configuration
public class IOConfig {

    @Bean
    public IOService ioService() {
        return new IOServiceStreams(System.out, System.in);
    }
}
