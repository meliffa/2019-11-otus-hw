package ru.otus.hw.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.hw.jpa.entity.Genre;
import ru.otus.hw.jpa.repository.genre.GenreRepository;
import ru.otus.hw.spring.HW06Application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@DisplayName("Test genre repository")
@SpringBootTest(classes = HW06Application.class)
public class GenreRepoImplTest {
    public static final String TEST_NEW_GENRE_NAME = "Стихи";
    public static final String TEST_EXISTING_GENRE_NAME = "Роман";
    public static final Integer TEST_EXISTING_GENRE_ID = 2;
    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("test create genre")
    void testCreateGenre() {
        Genre genre = new Genre();
        genre.setGenreName(TEST_NEW_GENRE_NAME);
        genreRepository.insert(genre);
        Genre createdGenre= genreRepository.getByName(TEST_NEW_GENRE_NAME);
        assertNotNull(createdGenre.getGenreId());
        assertEquals(createdGenre.getGenreName(), genre.getGenreName());
    }

    @Test
    @DisplayName("test getting existing genre by id")
    void testGetExistingGenreById() {
        Genre dataGenre = genreRepository.getById(TEST_EXISTING_GENRE_ID);
        assertNotNull(dataGenre);
        assertEquals(dataGenre.getGenreName(), TEST_EXISTING_GENRE_NAME);
    }

    @Test
    @DisplayName("test getting author by name")
    void testGetGenreByName() {
        Genre existingGenre = genreRepository.getByName(TEST_EXISTING_GENRE_NAME);
        assertNotNull(existingGenre.getGenreId());
        assertEquals(existingGenre.getGenreId(), TEST_EXISTING_GENRE_ID);
    }
}
