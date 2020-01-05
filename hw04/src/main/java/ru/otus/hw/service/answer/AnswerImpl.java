package ru.otus.hw.service.answer;

import org.springframework.stereotype.Service;
import ru.otus.hw.service.answer.reader.AnswerReaderProvider;

import java.util.Map;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Service
public class AnswerImpl implements AnswerProvider {

    private final AnswerReaderProvider answerReader;

    public AnswerImpl(AnswerReaderProvider answerReader) {
        this.answerReader = answerReader;
    }


    @Override
    public Map getAnswers() {
        return answerReader.readAnswers();
    }
}
