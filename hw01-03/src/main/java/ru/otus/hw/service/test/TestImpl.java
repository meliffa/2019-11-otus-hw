package ru.otus.hw.service.test;

import org.springframework.stereotype.Service;
import ru.otus.hw.entity.Answer;
import ru.otus.hw.entity.Question;
import ru.otus.hw.entity.Test;
import ru.otus.hw.entity.User;
import ru.otus.hw.utils.io.IOProvider;
import ru.otus.hw.utils.messages.MessageProvider;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Service
public class TestImpl implements TestProvider {
    private final IOProvider ioProvider;
    private final MessageProvider messageProvider;

    public TestImpl(IOProvider ioProvider, MessageProvider messageProvider) {
        this.ioProvider = ioProvider;
        this.messageProvider = messageProvider;
    }

    @Override
    public void doTest(Test test) {
        ioProvider.print(messageProvider.getMessage("HW.TestStart"));
        int qNum = 1;
        List<Question> questions = test.getQuestions();
        Map<Integer, LinkedList<Answer>> answers = test.getAnswers();

        for (Question question : questions) {
            List<Answer> answerList = answers.get(question.getId());

            showQuestion(question, answerList, qNum);

            int answerId = getAnswerId(answerList);
            if (checkAnswer(answerId, answerList)) {
                test.updateCorrectAnswerCount();
            }
            qNum++;
        }
        endTest(test.getUser(), test.getCorrectAnswerCount());
    }

    private void showQuestion(Question question, List<Answer> answers, int qNum) {
        ioProvider.print("");
        ioProvider.print(messageProvider.getFormattedMessage("HW.QuestionNum", qNum));
        ioProvider.print(question.getQuestion());
        ioProvider.print("");
        ioProvider.print(messageProvider.getMessage("HW.AnswerOptions"));
        for (Answer answer : answers) {
            ioProvider.print(answer.getAnswerId() + ". " + answer.getAnswer());
        }
    }

    private int getAnswerId(List<Answer> answers) {
        boolean answered = false;
        int answerId = 0;
        ioProvider.print("");
        ioProvider.print(messageProvider.getMessage("HW.EnterAnswerId"));
        while (!answered) {
            try {
                answerId = Integer.parseInt(ioProvider.read());
                if (answerId < 1 || answerId > answers.size()) {
                    ioProvider.print(messageProvider.getMessage("HW.WrongAnswerId"));
                } else answered = true;
            } catch (NumberFormatException nfe) {
                ioProvider.print(messageProvider.getMessage("HW.WrongAnswerId"));
            }
        }
        return answerId;
    }

    private boolean checkAnswer(int answerId, List<Answer> answers) {
        if (answers.get(answerId - 1).isCorrectAnswer()) {
            ioProvider.print(messageProvider.getMessage("HW.CorrectAnswer"));
            return true;
        }
        ioProvider.print(messageProvider.getMessage("HW.IncorrectAnswer"));
        return false;
    }

    private void endTest(User user, int correctAnswerCount) {
        ioProvider.print("");
        ioProvider.print(messageProvider.getFormattedMessage(
                "HW.TestResult",
                user.getName() + " " + user.getSurname(),
                correctAnswerCount
        ));
    }
}
