package ru.otus.hw.service.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.hw.entity.Answer;
import ru.otus.hw.entity.Question;
import ru.otus.hw.entity.User;
import ru.otus.hw.utils.io.IOProvider;
import ru.otus.hw.utils.messages.MessageProvider;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */

@DisplayName("TestImpl test")
public class TestImplTest {
    private static User testUser;
    private static List<Question> testQuestions;
    private static Map<Integer, LinkedList<Answer>> testAnswers;
    private static ru.otus.hw.entity.Test test;

    @BeforeAll
    static void init() {
        testUser = createTestUser();
        testQuestions = createTestQuestions();
        testAnswers = createTestAnswers();
        test = new ru.otus.hw.entity.Test(
                testUser,
                testQuestions,
                testAnswers
        );
    }

    @Test
    @DisplayName("Test doTest")
    void testDoTest() {
        IOProvider ioProvider = mock(IOProvider.class);
        MessageProvider messageProvider = mock(MessageProvider.class);
        Mockito.when(ioProvider.read()).thenReturn("3");

        TestImpl testService = new TestImpl(ioProvider, messageProvider);
        testService.doTest(test);
        assertEquals(1, test.getCorrectAnswerCount());
    }

    private static User createTestUser() {
        return new User("John", "Doe");
    }

    private static List<Question> createTestQuestions() {
        List<Question> questions = new ArrayList<Question>();
        Question question = new Question(1, "Чтобы правильно задать вопрос, большую часть чего нужно знать?");
        questions.add(question);
        return questions;
    }

    private static Map createTestAnswers() {
        List<Answer> answers = new LinkedList<>();
        Answer answer1 = new Answer("42", 1, false);
        answers.add(answer1);

        Answer answer2 = new Answer("всего", 2, false);
        answers.add(answer2);

        Answer answer3 = new Answer("ответа", 3, true);
        answers.add(answer3);

        Map answerMap = new HashMap();
        answerMap.put(1, answers);
        return answerMap;
    }
}
