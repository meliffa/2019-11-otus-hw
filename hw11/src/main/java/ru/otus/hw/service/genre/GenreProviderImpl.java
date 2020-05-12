package ru.otus.hw.service.genre;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Genre;
import ru.otus.hw.db.repository.GenreRepository;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
@RequiredArgsConstructor
public class GenreProviderImpl implements GenreProvider {
    private final GenreRepository genreRepository;

    @Override
    public Mono<Genre> getByName(String name) {
        return genreRepository.findByGenreNameIgnoreCase(name);
    }

    @Override
    public Flux<Genre> getAll() {
        return genreRepository.findAll();
    }
}
