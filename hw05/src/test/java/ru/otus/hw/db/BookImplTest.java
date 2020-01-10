package ru.otus.hw.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.hw.entity.Book;
import ru.otus.hw.service.book.BookImpl;
import ru.otus.hw.spring.HW05Application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Inna Spodarik on 10.01.2020.
 */
@DisplayName("Test book impl provider")
@SpringBootTest(classes = HW05Application.class)
public class BookImplTest {
    @Autowired
    private BookImpl bookImpl;

    public static final String TEST_EXISTING_BOOK_NAME = "451 градус по фаренгейту";
    public static final Integer TEST_EXISTING_BOOK_ID = 1;

    @Test
    @DisplayName("test getting book by id")
    void testGetBookById() {
        Book dataBook = bookImpl.getBookById(TEST_EXISTING_BOOK_ID);
        assertNotNull(dataBook);
        assertEquals(dataBook.getBookName(), TEST_EXISTING_BOOK_NAME);
    }
}
