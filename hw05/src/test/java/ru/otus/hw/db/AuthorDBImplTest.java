package ru.otus.hw.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.hw.db.author.AuthorDBImpl;
import ru.otus.hw.entity.Author;
import ru.otus.hw.spring.HW05Application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@DisplayName("Test author db provider")
@SpringBootTest(classes = HW05Application.class)
public class AuthorDBImplTest {
    public static final String TEST_NEW_AUTHOR_NAME = "Ирвин Шоу";
    public static final String TEST_EXISTING_AUTHOR_NAME = "Рэй Брэдбери";
    public static final Integer TEST_EXISTING_AUTHOR_ID = 1;
    @Autowired
    private AuthorDBImpl authorDBImpl;

    @Test
    @DisplayName("test create author")
    void testCreateAuthor() {
        Author author = new Author(TEST_NEW_AUTHOR_NAME);
        authorDBImpl.insertAuthor(author);
        Author createdAuthor = authorDBImpl.getAuthorByName(TEST_NEW_AUTHOR_NAME);
        assertNotNull(createdAuthor.getAuthorId());
        assertEquals(createdAuthor.getAuthorName(), author.getAuthorName());
    }

    @Test
    @DisplayName("test getting existing author by id")
    void testGetExistingAuthorById() {
        Author dataAuthor = authorDBImpl.getExistingAuthorById(TEST_EXISTING_AUTHOR_ID);
        assertNotNull(dataAuthor.getAuthorName());
        assertEquals(dataAuthor.getAuthorName(), TEST_EXISTING_AUTHOR_NAME);
    }

    @Test
    @DisplayName("test getting author by name")
    void testGetAuthorByName() {
        Author existingAuthor = authorDBImpl.getAuthorByName(TEST_EXISTING_AUTHOR_NAME);
        assertNotNull(existingAuthor.getAuthorId());
        assertEquals(existingAuthor.getAuthorId(), TEST_EXISTING_AUTHOR_ID);
    }
}
