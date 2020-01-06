package ru.otus.hw.utils.shell.book;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface BookShellUtilsProvider {
    void create();
    void updateById(Integer id);
    void deleteById(Integer id);
    void getByName(String name);
    void getById(Integer id);
    void browse();
}
