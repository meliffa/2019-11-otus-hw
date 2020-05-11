package ru.otus.hw.service.author;

import ru.otus.hw.dto.AuthorDTO;

import java.util.List;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface AuthorProvider {
    void create(AuthorDTO author);
    void update(AuthorDTO author);
    List<AuthorDTO> getAll();
}
