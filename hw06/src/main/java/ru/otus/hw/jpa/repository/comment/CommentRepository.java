package ru.otus.hw.jpa.repository.comment;

import ru.otus.hw.jpa.entity.Comment;

import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface CommentRepository {
    Comment getById(Integer bookId);
    List<Comment> getByBookId(Integer bookId);
    void insert(Comment comment);
    void update(Comment comment);
    void deleteById(Integer commentId);
    List<Comment> getAll();
}
