package ru.otus.hw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Data
@AllArgsConstructor
public class Test {
    private User user;
    private List<Question> questions;
    private Map<Integer, LinkedList<Answer>> answers;
    private int correctAnswerCount = 0;

    public Test(User user, List<Question> questions, Map<Integer, LinkedList<Answer>> answers) {
        this.user = user;
        this.questions = questions;
        this.answers = answers;
    }

    public void updateCorrectAnswerCount() {
        this.correctAnswerCount++;
    }
}
