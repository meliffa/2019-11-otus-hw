package ru.otus.hw.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import ru.otus.hw.db.entity.Author;
import ru.otus.hw.db.entity.Genre;
import ru.otus.hw.db.repository.AuthorRepository;
import ru.otus.hw.db.repository.GenreRepository;
import ru.otus.hw.spring.HW11Application;

/**
 * Created by Inna Spodarik on 12.05.2020.
 */
@DisplayName("Test genre repository")
@SpringBootTest(classes = HW11Application.class)
public class GenreRepoImplTest {
    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("test get genres")
    void testGetAuthors() {
        Flux<Genre> genres = genreRepository.findAll();
        StepVerifier
                .create(genres)
                .expectNextCount(4)
                .verifyComplete();
    }
}
