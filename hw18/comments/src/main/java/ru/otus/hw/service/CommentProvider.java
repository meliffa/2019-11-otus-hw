package ru.otus.hw.service;

import ru.otus.hw.dto.CommentDTO;

import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface CommentProvider {
    List<CommentDTO> getByBookId(Integer bookId);
}
