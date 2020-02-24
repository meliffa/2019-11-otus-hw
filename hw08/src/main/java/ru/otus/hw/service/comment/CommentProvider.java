package ru.otus.hw.service.comment;

import ru.otus.hw.dto.CommentDTO;

import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface CommentProvider {
    void create(CommentDTO comment);
    CommentDTO getById(String id);
    List<CommentDTO> getByBookId(String bookId);
    void update(CommentDTO comment);
    void deleteById(String id);
    List<CommentDTO> getAll();
}
