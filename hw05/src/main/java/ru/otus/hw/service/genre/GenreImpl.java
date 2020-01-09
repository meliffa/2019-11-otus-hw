package ru.otus.hw.service.genre;

import org.springframework.stereotype.Service;
import ru.otus.hw.db.genre.GenreDBProvider;
import ru.otus.hw.entity.Genre;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
public class GenreImpl implements GenreProvider {

    private final GenreDBProvider dbGenreProvider;

    public GenreImpl(GenreDBProvider provider) {
        this.dbGenreProvider = provider;
    }

    @Override
    public void createGenre(Genre genre) {
        dbGenreProvider.insertGenre(genre);
    }

    @Override
    public Genre getExistingGenreById(Integer genreId) {
        return dbGenreProvider.getExistingGenreById(genreId);
    }

    @Override
    public Genre getGenreByName(String genreName) {
        return dbGenreProvider.getGenreByName(genreName);
    }

    @Override
    public Genre getOrCreateGenreByName(String genreName) {
        if (dbGenreProvider.getGenreByName(genreName) == null) dbGenreProvider.insertGenre(new Genre(genreName));
        return dbGenreProvider.getGenreByName(genreName);
    }
}
