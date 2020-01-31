package ru.otus.hw.service.test;

import org.springframework.stereotype.Service;
import ru.otus.hw.entity.Test;
import ru.otus.hw.entity.User;
import ru.otus.hw.service.answer.AnswerProvider;
import ru.otus.hw.service.question.QuestionProvider;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Service
public class TestMakerImpl implements TestMakerProvider {
    private final QuestionProvider questionProvider;
    private final AnswerProvider answerProvider;

    public TestMakerImpl(QuestionProvider questionProvider, AnswerProvider answerProvider) {
        this.questionProvider = questionProvider;
        this.answerProvider = answerProvider;
    }
    @Override
    public Test makeTest(User user) {
        return new Test(user, questionProvider.getQuestions(), answerProvider.getAnswers());
    }
}
