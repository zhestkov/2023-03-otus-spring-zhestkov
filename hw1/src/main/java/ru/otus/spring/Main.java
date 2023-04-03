package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.QuestionPrinterService;

public class Main {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        var printerService = ctx.getBean(QuestionPrinterService.class);
        printerService.printQuestions();
    }
}