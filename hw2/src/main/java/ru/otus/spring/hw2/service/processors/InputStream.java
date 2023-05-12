package ru.otus.spring.hw2.service.processors;

public interface InputStream {

    String readString();

    String readStringWithPrompt(String prompt);
}
