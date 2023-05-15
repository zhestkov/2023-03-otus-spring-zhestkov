package ru.otus.spring.hw2.domain.exception;

public class CsvReadException extends RuntimeException {
    public CsvReadException(String msg) {
        super(msg);
    }
}
