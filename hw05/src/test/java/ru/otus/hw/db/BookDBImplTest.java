package ru.otus.hw.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.db.author.AuthorDBImpl;
import ru.otus.hw.db.book.BookDBImpl;
import ru.otus.hw.db.genre.GenreDBImpl;
import ru.otus.hw.entity.Author;
import ru.otus.hw.entity.Book;
import ru.otus.hw.entity.Genre;
import ru.otus.hw.spring.HW05Application;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */

@DisplayName("Test book db provider")
@SpringBootTest(classes = HW05Application.class)
@Transactional
public class BookDBImplTest {
    public static final String TEST_NEW_BOOK_NAME = "Чума";
    public static final String TEST_NEW_AUTHOR_NAME = "Альбер Камю";
    public static final String TEST_NEW_GENRE_NAME = "Философский роман";
    public static final Integer TEST_NEW_BOOK_ID = 6;

    public static final Integer TEST_EXPECTED_BOOKS_SIZE = 5;

    public static final String TEST_EXISTING_BOOK_NAME = "451 градус по фаренгейту";
    public static final Integer TEST_EXISTING_BOOK_ID = 1;
    @Autowired
    private AuthorDBImpl authorDBImpl;
    @Autowired
    private GenreDBImpl genreDBImpl;
    @Autowired
    private BookDBImpl bookDBImpl;

    @Test
    @DisplayName("test create book")
    void testCreateBook() {
        Author author = new Author(TEST_NEW_AUTHOR_NAME);
        authorDBImpl.insertAuthor(author);
        Author createdAuthor = authorDBImpl.getAuthorByName(TEST_NEW_AUTHOR_NAME);

        Genre genre = new Genre(TEST_NEW_GENRE_NAME);
        genreDBImpl.insertGenre(genre);
        Genre createdGenre= genreDBImpl.getGenreByName(TEST_NEW_GENRE_NAME);

        Book book = new Book(TEST_NEW_BOOK_NAME);
        book.setGenre(createdGenre);
        book.setAuthor(createdAuthor);
        bookDBImpl.insertBook(book);

        Book createdBook = bookDBImpl.getBookById(TEST_NEW_BOOK_ID);
        assertNotNull(createdBook);
        assertEquals(TEST_NEW_BOOK_NAME, createdBook.getBookName());
        assertEquals(createdAuthor, createdBook.getAuthor());
        assertEquals(createdGenre, createdBook.getGenre());
    }

    @Test
    @DisplayName("test delete book by id")
    void testDeleteBookById() {
        bookDBImpl.deleteBookById(TEST_EXISTING_BOOK_ID);
        Book existingBook = bookDBImpl.getBookById(TEST_EXISTING_BOOK_ID);
        assertNull(existingBook);
    }

    @Test
    @DisplayName("test getting existing book by id")
    void testGetExistingBookById() {
        Book dataBook = bookDBImpl.getBookById(TEST_EXISTING_BOOK_ID);
        assertNotNull(dataBook);
        assertEquals(dataBook.getBookName(), TEST_EXISTING_BOOK_NAME);
    }

    @Test
    @DisplayName("test getting book by name")
    void testGetBookByName() {
        List<Book> existingBooks = bookDBImpl.getBooksByName(TEST_EXISTING_BOOK_NAME);
        assertNotNull(existingBooks.get(0));
        Book existingBook = existingBooks.get(0);
        assertNotNull(existingBook.getBookId());
        assertEquals(existingBook.getBookId(), TEST_EXISTING_BOOK_ID);
    }

    @Test
    @DisplayName("test get all books")
    void testGetAllBooks() {
        List<Book> books = bookDBImpl.getAllBooks();
        assertThat(books.size()).isGreaterThan(1);
        assertThat(books.size()).isEqualTo(TEST_EXPECTED_BOOKS_SIZE);
    }

    @Test
    @DisplayName("test update book author")
    void testUpdateBookAuthor() {
        bookDBImpl.updateBookAuthor(TEST_EXISTING_BOOK_ID, 2);
        Book updatedBook = bookDBImpl.getBookById(TEST_EXISTING_BOOK_ID);
        assertThat(updatedBook.getAuthor().getAuthorId()).isEqualTo(2);
    }

    @Test
    @DisplayName("test update book genre")
    void testUpdateBookGenre() {
        bookDBImpl.updateBookGenre(TEST_EXISTING_BOOK_ID, 2);
        Book updatedBook = bookDBImpl.getBookById(TEST_EXISTING_BOOK_ID);
        assertThat(updatedBook.getGenre().getGenreId()).isEqualTo(2);
    }

    @Test
    @DisplayName("test update book name")
    void testUpdateBookName() {
        bookDBImpl.updateBookName(TEST_EXISTING_BOOK_ID, TEST_NEW_BOOK_NAME);
        Book updatedBook = bookDBImpl.getBookById(TEST_EXISTING_BOOK_ID);
        assertThat(updatedBook.getBookName()).isEqualTo(TEST_NEW_BOOK_NAME);
    }
}
