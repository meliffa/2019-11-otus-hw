package ru.otus.hw.utils.shell.comment;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface CommentShellUtilsProvider {
    void create(String bookId);
    void update(String id);
    void deleteById(String id);
    void browseByBookId(String bookId);
    void browse();
}
