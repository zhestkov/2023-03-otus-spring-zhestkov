package ru.otus.spring.hw2.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class User {

    private final String firstName;

    private final String lastName;

    private int cntCorrectAnswers = 0;

    public static User createUser(String firstName, String lastName) {
        return new User(firstName, lastName);
    }

    public void incrementCorrectAnswers() {
        ++cntCorrectAnswers;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}
