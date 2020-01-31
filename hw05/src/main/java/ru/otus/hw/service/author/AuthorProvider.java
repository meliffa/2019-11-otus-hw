package ru.otus.hw.service.author;

import ru.otus.hw.entity.Author;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface AuthorProvider {
    void createAuthor(Author author);
    Author getExistingAuthorById(Integer authorId);
    Author getAuthorByName(String authorName);
    Author getOrCreateAuthorByName(String authorName);
}
