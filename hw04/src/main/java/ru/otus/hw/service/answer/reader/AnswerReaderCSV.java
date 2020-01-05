package ru.otus.hw.service.answer.reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import ru.otus.hw.entity.Answer;
import ru.otus.hw.utils.ApplicationProperties;
import ru.otus.hw.utils.messages.MessageProvider;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Service
public class AnswerReaderCSV implements AnswerReaderProvider {

    private final ApplicationProperties properties;
    private final MessageProvider messageProvider;

    public AnswerReaderCSV(ApplicationProperties properties, MessageProvider messageProvider) {
        this.properties = properties;
        this.messageProvider = messageProvider;
    }

    @Override
    public Map readAnswers() {
        Map answersMap = new HashMap();

        try {
            File f = ResourceUtils.getFile(properties.getAnswersFileName());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8)
            );
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withTrim()
                    .withDelimiter(properties.getFileDelimiter().charAt(0))
            );
            for (CSVRecord csvRecord : csvParser) {
                List<Answer> answers = new LinkedList<>();
                try {
                    int id = Integer.parseInt(csvRecord.get(0));
                    int correctAnswerColumnId = Integer.parseInt(csvRecord.get(1));
                    int answerColumnId = 1;
                    for (int i = 2; i < csvRecord.size(); i++){
                        Answer answer = new Answer();
                        answer.setAnswer(csvRecord.get(i));
                        if (correctAnswerColumnId == answerColumnId) {
                            answer.setCorrectAnswer(true);
                        }
                        answer.setAnswerId(answerColumnId);
                        answerColumnId++;
                        answers.add(answer);
                    }
                    answersMap.put(id, answers);
                } catch (NumberFormatException e) {
                    System.out.println(
                            messageProvider.getFormattedMessage("HW.ErrorReadingAnswerFromFile", csvRecord.get(0))
                    );
                }
            }

        } catch (IOException ioe) {
            throw new RuntimeException(
                    messageProvider.getFormattedMessage(
                            "HW.ErrorReadingAnswersFile", properties.getAnswersFileName()
                    )
            );
        }
        return answersMap;
    }
}
