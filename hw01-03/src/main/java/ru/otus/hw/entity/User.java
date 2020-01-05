package ru.otus.hw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Data
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
}
