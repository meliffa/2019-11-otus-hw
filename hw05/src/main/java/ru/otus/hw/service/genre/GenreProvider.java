package ru.otus.hw.service.genre;

import ru.otus.hw.entity.Genre;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface GenreProvider {
    void createGenre(Genre genre);
    Genre getExistingGenreById(Integer genreId);
    Genre getGenreByName(String genreName);
    Genre getOrCreateGenreByName(String genreName);
}
