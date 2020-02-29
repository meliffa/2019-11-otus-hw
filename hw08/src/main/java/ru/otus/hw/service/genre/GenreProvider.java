package ru.otus.hw.service.genre;

import ru.otus.hw.dto.GenreDTO;
import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface GenreProvider {
    void create(GenreDTO genre);
    GenreDTO getById(String id);
    GenreDTO getByName(String name);
    GenreDTO getOrCreateByName(String name);
    void update(GenreDTO genre);
    void deleteById(String id);
    List<GenreDTO> getAll();
}
