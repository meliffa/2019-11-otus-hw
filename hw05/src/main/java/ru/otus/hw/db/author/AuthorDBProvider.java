package ru.otus.hw.db.author;

import ru.otus.hw.entity.Author;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
public interface AuthorDBProvider {
    Author getExistingAuthorById(Integer authorId);
    Author getAuthorByName(String authorName);
    void insertAuthor(Author author);
}
