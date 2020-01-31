package ru.otus.hw.utils.shell;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface ShellUtilsProvider {
    void create();
    void update();
    void deleteById(Integer id);
    void browse();
}
