import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring.hw2.Main;
import ru.otus.spring.hw2.dao.QuestionDao;
import ru.otus.spring.hw2.domain.Question;
import ru.otus.spring.hw2.service.IOService;
import ru.otus.spring.hw2.service.QuizServiceImpl;

import java.util.List;
import java.util.regex.Pattern;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith({SpringExtension.class, MockitoExtension.class})
@TestPropertySource("classpath:application-test.properties")
@ContextConfiguration(classes = {Main.class})
public class QuizServiceTest {

    @Mock
    QuestionDao questionLoader;

    @Mock
    IOService ioService;


    QuizServiceImpl quizService;


    private List<Question> generateData() {
        return List.of(
                new Question("question1", "true"),
                new Question("question2", "false")
        );
    }

    @BeforeEach
    public void setup() {
        quizService = new QuizServiceImpl(questionLoader, ioService);
        given(questionLoader.getQuestionList()).willReturn(generateData());
    }

    @Test
    public void testQuiz() {
        var firstName = "firstname";
        var lastName = "lastname";
        given(ioService.readStringWithPrompt(QuizServiceImpl.ASK_FIRSTNAME)).willReturn(firstName);
        given(ioService.readStringWithPrompt(QuizServiceImpl.ASK_LASTNAME)).willReturn(lastName);
        given(ioService.readStringWithPrompt("question1")).willReturn("true");
        given(ioService.readStringWithPrompt("question2")).willReturn("true");

        quizService.startQuiz();

        verify(ioService, times(1)).readStringWithPrompt(QuizServiceImpl.ASK_LASTNAME);
        verify(ioService, times(1)).readStringWithPrompt(QuizServiceImpl.ASK_LASTNAME);
        verify(ioService, times(1)).readStringWithPrompt(matches("question1"));
        verify(ioService, times(1)).readStringWithPrompt(matches("question2"));
        verify(ioService, times(1)).printString(matches("User firstname lastname answered correctly questions: 1 of 2"));


    }
}
