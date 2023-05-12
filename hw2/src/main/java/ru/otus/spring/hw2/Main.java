package ru.otus.spring.hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.hw2.service.QuizRunner;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Main.class);
        var quizRunner = ctx.getBean(QuizRunner.class);
        quizRunner.run();
    }
}
