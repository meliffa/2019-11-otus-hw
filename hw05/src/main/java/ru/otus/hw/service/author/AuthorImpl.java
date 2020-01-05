package ru.otus.hw.service.author;

import org.springframework.stereotype.Service;
import ru.otus.hw.db.author.AuthorDBProvider;
import ru.otus.hw.entity.Author;
import ru.otus.hw.entity.Genre;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
public class AuthorImpl implements AuthorProvider {
    private final AuthorDBProvider dbAuthorProvider;

    public AuthorImpl(AuthorDBProvider dbAuthorProvider) {
        this.dbAuthorProvider = dbAuthorProvider;
    }

    @Override
    public void createAuthor(Author author) {
        dbAuthorProvider.insertAuthor(author);
    }

    @Override
    public Author getExistingAuthorById(Integer authorId) {
        return dbAuthorProvider.getExistingAuthorById(authorId);
    }

    @Override
    public Author getAuthorByName(String authorName) {
        return dbAuthorProvider.getAuthorByName(authorName);
    }

    @Override
    public Author getOrCreateAuthorByName(String authorName) {
        if (dbAuthorProvider.getAuthorByName(authorName) == null) dbAuthorProvider.insertAuthor(new Author(authorName));
        return dbAuthorProvider.getAuthorByName(authorName);
    }
}
