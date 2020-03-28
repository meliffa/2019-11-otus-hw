package ru.otus.hw.service.author;

import ru.otus.hw.dto.AuthorDTO;

import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface AuthorProvider {
    void create(AuthorDTO author);
    AuthorDTO getById(Integer id);
    AuthorDTO getByName(String name);
    AuthorDTO getOrCreateByName(String name);
    void update(AuthorDTO author);
    void deleteById(Integer id);
    List<AuthorDTO> getAll();
    AuthorDTO getByNameWithBooks(String name);
}
