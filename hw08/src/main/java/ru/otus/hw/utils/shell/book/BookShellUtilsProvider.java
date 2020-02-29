package ru.otus.hw.utils.shell.book;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface BookShellUtilsProvider {
    void create();
    void updateById(String id);
    void deleteById(String id);
    void getByName(String name);
    void getById(String id);
    void browse();
    void getByAuthorName(String authorName);
}
