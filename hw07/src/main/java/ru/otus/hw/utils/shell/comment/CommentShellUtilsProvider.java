package ru.otus.hw.utils.shell.comment;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface CommentShellUtilsProvider {
    void create(Integer bookId);
    void update(Integer id);
    void deleteById(Integer id);
    void browseByBookId(Integer bookId);
    void browse();
}
