package ru.otus.hw.jpa.repository.author;

import ru.otus.hw.jpa.entity.Author;

import java.util.List;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
public interface AuthorRepository {
    Author getById(Integer authorId);
    Author getByName(String authorName);
    void insert(Author author);
    void update(Author author);
    void deleteById(Integer authorId);
    List<Author> getAll();
}
