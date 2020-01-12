package ru.otus.hw.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.hw.db.book.BookDBProvider;
import ru.otus.hw.entity.Author;
import ru.otus.hw.entity.Book;
import ru.otus.hw.entity.Genre;
import ru.otus.hw.service.book.BookImpl;
import ru.otus.hw.spring.HW05Application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by Inna Spodarik on 10.01.2020.
 */
@DisplayName("Test book impl provider")
@SpringBootTest(classes = HW05Application.class)
public class BookImplTest {

    public static final String TEST_EXISTING_BOOK_NAME = "test book";
    public static final Integer TEST_EXISTING_BOOK_ID = 3;

    @Test
    @DisplayName("test getting book by id")
    void testGetBookById() {
        BookDBProvider bookDBProvider = mock(BookDBProvider.class);
        Mockito.when(bookDBProvider.getBookById(TEST_EXISTING_BOOK_ID)).thenReturn(
                new Book(TEST_EXISTING_BOOK_ID, TEST_EXISTING_BOOK_NAME, new Author(), new Genre())
        );
        BookImpl bookImpl = new BookImpl(bookDBProvider);
        Book dataBook = bookImpl.getBookById(TEST_EXISTING_BOOK_ID);
        assertNotNull(dataBook);
        assertEquals(dataBook.getBookName(), TEST_EXISTING_BOOK_NAME);
    }
}
