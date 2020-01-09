package ru.otus.hw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private int id;
    private String question;
}
