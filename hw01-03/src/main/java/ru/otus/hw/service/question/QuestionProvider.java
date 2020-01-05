package ru.otus.hw.service.question;

import ru.otus.hw.entity.Question;

import java.util.List;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
public interface QuestionProvider {
    List<Question> getQuestions();
}
