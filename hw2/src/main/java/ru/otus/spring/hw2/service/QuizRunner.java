package ru.otus.spring.hw2.service;

import org.springframework.stereotype.Service;

@Service
public class QuizRunner {

    private final QuizService quizService;

    public QuizRunner(QuizService quizService) {
        this.quizService = quizService;
    }

    public void run() {
        quizService.startQuiz();
    }
}
