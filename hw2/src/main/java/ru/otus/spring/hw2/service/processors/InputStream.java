package ru.otus.spring.hw2.service.processors;

public interface InputStream {

    String readLine();

    String readLineWithPrompt(String prompt);
}
