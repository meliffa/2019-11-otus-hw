package ru.otus.hw.service.question;

import org.springframework.stereotype.Service;
import ru.otus.hw.entity.Question;
import ru.otus.hw.service.question.reader.QuestionReaderProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Service
public class QuestionImpl implements QuestionProvider {
    private final QuestionReaderProvider questionReader;

    public QuestionImpl(QuestionReaderProvider questionReader) {
        this.questionReader = questionReader;
    }

    @Override
    public List<Question> getQuestions() {
        return questionReader.readQuestions();
    }
}
