package ru.otus.hw.service.comment;

import ru.otus.hw.dto.CommentDTO;

import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface CommentProvider {
    void create(CommentDTO comment);
    CommentDTO getById(Integer id);
    List<CommentDTO> getByBookId(Integer bookId);
    void update(CommentDTO comment);
    void deleteById(Integer id);
    List<CommentDTO> getAll();
}
