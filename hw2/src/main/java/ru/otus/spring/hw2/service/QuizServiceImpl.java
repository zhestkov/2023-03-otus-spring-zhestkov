package ru.otus.spring.hw2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring.hw2.dao.QuestionDao;
import ru.otus.spring.hw2.domain.Question;
import ru.otus.spring.hw2.domain.User;


@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    public static final String GREETINGS = "Welcome to the quiz game!";

    public static final String ASK_FIRSTNAME = "What is your firstname?";

    public static final String ASK_LASTNAME = "What is your lastname?";

    private final QuestionDao questionDao;

    private final IOService ioService;

    @Override
    public void startQuiz() {
        var user = greetingUser();
        var questionList = questionDao.findAll();
        for (var q : questionList) {
            String answer = ioService.readLineWithPrompt(q.title());
            if (validateAnswer(answer, q)) {
                user.incrementCorrectAnswers();
            }
        }

        var summary = getSummary(user, questionList.size());
        ioService.print(summary);
    }

    private User greetingUser() {
        ioService.print(GREETINGS);
        String firstName = ioService.readLineWithPrompt(ASK_FIRSTNAME);
        String lastName = ioService.readLineWithPrompt(ASK_LASTNAME);
        return User.createUser(firstName, lastName);
    }

    private boolean validateAnswer(String userAnswer, Question question) {
        return userAnswer.equals(question.correctAnswer());
    }

    private String getSummary(User user, int totalQuestions) {
        return String.format("User %s answered correctly questions: %d of %d",
                user.fullName(), user.getCntCorrectAnswers(), totalQuestions);
    }
}
