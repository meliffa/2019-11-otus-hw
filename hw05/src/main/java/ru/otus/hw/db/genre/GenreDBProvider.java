package ru.otus.hw.db.genre;

import ru.otus.hw.entity.Genre;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface GenreDBProvider {
    Genre getExistingGenreById(Integer genreId);
    Genre getGenreByName(String genreName);
    void insertGenre(Genre genre);
}
