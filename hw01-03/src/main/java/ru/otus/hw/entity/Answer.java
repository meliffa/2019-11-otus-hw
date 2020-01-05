package ru.otus.hw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    private String answer;
    private int answerId;
    private boolean correctAnswer = false;
}
