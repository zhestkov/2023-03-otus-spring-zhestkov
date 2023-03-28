package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.QuestionPrinterService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionPrinterService printerService = ctx.getBean(QuestionPrinterService.class);
        printerService.printQuestions();

        ctx.close();
    }
}