package ru.otus.hw.service.comment;

import ru.otus.hw.dto.CommentDTO;

import java.util.List;

/**
 * Created by Inna Spodarik on 11.05.2020.
 */
public interface CommentProvider {
    List<CommentDTO> getBookComments(Integer bookId);
}
