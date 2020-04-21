package ru.otus.hw.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.hw.jpa.entity.Author;
import ru.otus.hw.jpa.repository.author.AuthorRepository;
import ru.otus.hw.HW13Application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@DisplayName("Test author repository")
@SpringBootTest(classes = HW13Application.class)
public class AuthorRepoImplTest {
    public static final String TEST_NEW_AUTHOR_NAME = "Ирвин Шоу";
    public static final String TEST_EXISTING_AUTHOR_NAME = "Рэй Брэдбери";
    public static final Integer TEST_EXISTING_AUTHOR_ID = 1;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("test create author")
    void testCreateAuthor() {
        Author author = Author.builder()
                .authorName(TEST_NEW_AUTHOR_NAME)
                .build();
        author.setAuthorName(TEST_NEW_AUTHOR_NAME);
        authorRepository.save(author);
        Author createdAuthor = authorRepository.findByAuthorName(TEST_NEW_AUTHOR_NAME).orElse(Author.builder().build());
        assertNotNull(createdAuthor.getAuthorId());
        assertEquals(createdAuthor.getAuthorName(), author.getAuthorName());
    }

    @Test
    @DisplayName("test getting existing author by id")
    void testGetExistingAuthorById() {
        Author dataAuthor = authorRepository.findById(TEST_EXISTING_AUTHOR_ID).orElse(Author.builder().build());
        assertNotNull(dataAuthor.getAuthorName());
        assertEquals(dataAuthor.getAuthorName(), TEST_EXISTING_AUTHOR_NAME);
    }

    @Test
    @DisplayName("test getting author by name")
    void testGetAuthorByName() {
        Author existingAuthor = authorRepository.findByAuthorName(TEST_EXISTING_AUTHOR_NAME).orElse(Author.builder().build());
        assertNotNull(existingAuthor.getAuthorId());
        assertEquals(existingAuthor.getAuthorId(), TEST_EXISTING_AUTHOR_ID);
    }
}
