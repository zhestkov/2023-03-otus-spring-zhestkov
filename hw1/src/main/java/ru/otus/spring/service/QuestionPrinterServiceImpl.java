package ru.otus.spring.service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.dao.QuestionDao;

import java.io.PrintStream;

@RequiredArgsConstructor
public class QuestionPrinterServiceImpl implements QuestionPrinterService {

    private final QuestionDao questionDao;

    private final PrintStream out;

    @Override
    public void printQuestions() {
        questionDao.getQuestionList()
                .forEach(q -> out.println(q.title()));
    }
}
