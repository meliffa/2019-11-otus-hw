package ru.otus.hw.jpa.repository.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw.jpa.entity.Genre;

import java.util.Optional;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByGenreName(String genreName);
}
