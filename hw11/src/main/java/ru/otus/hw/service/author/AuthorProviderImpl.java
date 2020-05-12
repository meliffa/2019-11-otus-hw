package ru.otus.hw.service.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Author;
import ru.otus.hw.db.repository.AuthorRepository;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
@RequiredArgsConstructor
public class AuthorProviderImpl implements AuthorProvider {
    private final AuthorRepository authorRepository;

    @Override
    public Mono<Author> getByName(String name) {
        return authorRepository.findByAuthorNameIgnoreCase(name);
    }

    @Override
    public Flux<Author> getAll() {
        return authorRepository.findAll();
    }
}
