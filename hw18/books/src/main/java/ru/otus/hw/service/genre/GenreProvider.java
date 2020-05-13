package ru.otus.hw.service.genre;

import ru.otus.hw.dto.GenreDTO;

import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface GenreProvider {
    void create(GenreDTO genre);
    void update(GenreDTO genre);
    List<GenreDTO> getAll();
}
