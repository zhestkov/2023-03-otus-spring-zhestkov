import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Question;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    @Test
    public void testQuestionDomain() {
        var QUESTION_TITLE = "How old are you?";
        var QUESTION_ANSWER = 15;

        var question = new Question("How old are you?", "15");

        assertEquals(QUESTION_TITLE, question.title());
        assertEquals(Integer.toString(QUESTION_ANSWER), question.correctAnswer());
    }
}
