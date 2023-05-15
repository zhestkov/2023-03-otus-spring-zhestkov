package ru.otus.spring.hw2.service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class IOServiceStreams implements IOService {

    private final PrintStream output;

    private final Scanner input;

    public IOServiceStreams(PrintStream output, InputStream inputStream) {
        this.output = output;
        this.input = new Scanner(inputStream);
    }

    @Override
    public String readLine() {
        return input.nextLine();
    }

    @Override
    public String readLineWithPrompt(String prompt) {
        print(prompt);
        return readLine();
    }

    @Override
    public void print(String s) {
        output.println(s);
    }
}
