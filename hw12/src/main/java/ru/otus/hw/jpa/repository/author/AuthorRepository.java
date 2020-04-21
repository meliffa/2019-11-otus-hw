package ru.otus.hw.jpa.repository.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw.jpa.entity.Author;

import java.util.List;
import java.util.Optional;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findByAuthorName(String authorName);
}
