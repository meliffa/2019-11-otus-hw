package ru.otus.hw.service.question.reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import ru.otus.hw.entity.Question;
import ru.otus.hw.utils.ApplicationProperties;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Service
public class QuestionReaderCSV implements QuestionReaderProvider {
    private final ApplicationProperties properties;

    public QuestionReaderCSV(ApplicationProperties properties) {
        this.properties = properties;
    }

    @Override
    public List<Question> readQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            File f = ResourceUtils.getFile(properties.getQuestionsFileName());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8)
            );
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withTrim()
                    .withDelimiter(properties.getFileDelimiter().charAt(0))
            );
            for (CSVRecord csvRecord : csvParser) {
                try {
                    Question question = new Question();
                    question.setId(Integer.parseInt(csvRecord.get(0)));
                    question.setQuestion(csvRecord.get(1));
                    questions.add(question);
                } catch (NumberFormatException e) {
                    System.out.println("Error reading question from questions file with id = " + csvRecord.get(0));
                }
            }

        } catch (IOException ioe) {
            throw new RuntimeException("Error reading questions file by path = " + properties.getQuestionsFileName());
        }
        return questions;
    }
}
