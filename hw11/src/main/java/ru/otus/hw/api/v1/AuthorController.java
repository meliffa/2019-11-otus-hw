package ru.otus.hw.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Author;
import ru.otus.hw.service.author.AuthorProvider;

/**
 * Created by Inna Spodarik on 12.05.2020.
 */
@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorProvider authorProvider;

    @GetMapping("/authors/v1")
    public Flux<Author> getAuthors() {
        return authorProvider.getAll();
    }

    @GetMapping("/author/v1/{authorName}")
    public Mono<Author> getAuthorByName(@PathVariable("authorName") String authorName) {
        return authorProvider.getByName(authorName);
    }
}
