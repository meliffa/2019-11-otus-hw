package ru.otus.hw.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Genre;
import ru.otus.hw.service.genre.GenreProvider;

/**
 * Created by Inna Spodarik on 12.05.2020.
 */
@RestController
@RequiredArgsConstructor
public class GenreController {
    private final GenreProvider genreProvider;

    @GetMapping("/genres/v1")
    public Flux<Genre> getGenres() {
        return genreProvider.getAll();
    }

    @GetMapping("/genre/v1/{genreName}")
    public Mono<Genre> getGenreByName(@PathVariable("genreName") String genreName) {
        return genreProvider.getByName(genreName);
    }
}
