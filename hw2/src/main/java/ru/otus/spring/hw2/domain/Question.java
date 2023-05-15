package ru.otus.spring.hw2.domain;


import lombok.Builder;


@Builder
public record Question(String title, String correctAnswer) {
}
