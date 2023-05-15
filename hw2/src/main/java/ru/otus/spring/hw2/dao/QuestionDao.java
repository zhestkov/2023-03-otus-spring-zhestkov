package ru.otus.spring.hw2.dao;

import ru.otus.spring.hw2.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> findAll();
}
