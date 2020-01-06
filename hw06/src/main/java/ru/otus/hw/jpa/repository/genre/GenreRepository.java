package ru.otus.hw.jpa.repository.genre;

import ru.otus.hw.jpa.entity.Genre;

import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface GenreRepository {
    Genre getById(Integer genreId);
    Genre getByName(String genreName);
    void insert(Genre genre);
    void update(Genre genre);
    void deleteById(Integer genreId);
    List<Genre> getAll();
}
