package ru.otus.hw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Inna Spodarik on 28.04.2020.
 */
@Data
@AllArgsConstructor
public class Mail {
    String from;
    String to;
    String subject;
    String message;
}
