package ru.otus.spring.domain;


import lombok.Builder;


@Builder
public record Question(String title, String correctAnswer) {
}
