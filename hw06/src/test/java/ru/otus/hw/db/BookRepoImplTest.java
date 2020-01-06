package ru.otus.hw.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.dto.GenreDTO;
import ru.otus.hw.jpa.entity.Author;
import ru.otus.hw.jpa.entity.Book;
import ru.otus.hw.jpa.entity.Genre;
import ru.otus.hw.jpa.repository.author.AuthorRepository;
import ru.otus.hw.jpa.repository.book.BookRepository;
import ru.otus.hw.jpa.repository.genre.GenreRepository;
import ru.otus.hw.spring.HW06Application;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */

@DisplayName("Test book repository")
@SpringBootTest(classes = HW06Application.class)
@Transactional
public class BookRepoImplTest {
    public static final String TEST_NEW_BOOK_NAME = "Чума";
    public static final String TEST_NEW_AUTHOR_NAME = "Альбер Камю";
    public static final String TEST_NEW_GENRE_NAME = "Философский роман";
    public static final Integer TEST_NEW_BOOK_ID = 6;

    public static final Integer TEST_EXPECTED_BOOKS_SIZE = 5;

    public static final String TEST_EXISTING_BOOK_NAME = "451 градус по фаренгейту";
    public static final Integer TEST_EXISTING_BOOK_ID = 1;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("test create book")
    void testCreateBook() {
        Author author = new Author();
        author.setAuthorName(TEST_NEW_AUTHOR_NAME);
        authorRepository.insert(author);
        Author createdAuthor = authorRepository.getByName(TEST_NEW_AUTHOR_NAME);

        Genre genre = new Genre();
        genre.setGenreName(TEST_NEW_GENRE_NAME);
        genreRepository.insert(genre);
        Genre createdGenre= genreRepository.getByName(TEST_NEW_GENRE_NAME);

        Book book = new Book();
        book.setBookName(TEST_NEW_BOOK_NAME);
        book.setGenreId(createdGenre.getGenreId());
        book.setAuthorId(createdAuthor.getAuthorId());
        bookRepository.insert(book);

        Book createdBook = bookRepository.getById(TEST_NEW_BOOK_ID);
        assertNotNull(createdBook);
        assertEquals(TEST_NEW_BOOK_NAME, createdBook.getBookName());
        assertEquals(createdAuthor.getAuthorId(), createdBook.getAuthorId());
        assertEquals(createdGenre.getGenreId(), createdBook.getGenreId());
    }

    @Test
    @DisplayName("test delete book by id")
    void testDeleteBookById() {
        bookRepository.deleteById(TEST_EXISTING_BOOK_ID);
        Book existingBook = bookRepository.getById(TEST_EXISTING_BOOK_ID);
        assertNull(existingBook);
    }

    @Test
    @DisplayName("test getting book by id")
    void testGetBookById() {
        Book dataBook = bookRepository.getById(TEST_EXISTING_BOOK_ID);
        assertNotNull(dataBook);
        assertEquals(dataBook.getBookName(), TEST_EXISTING_BOOK_NAME);
    }

    @Test
    @DisplayName("test getting book by name")
    void testGetBookByName() {
        List<Book> existingBooks = bookRepository.getByName(TEST_EXISTING_BOOK_NAME);
        assertNotNull(existingBooks.get(0));
        Book existingBook = existingBooks.get(0);
        assertNotNull(existingBook.getBookId());
        assertEquals(existingBook.getBookId(), TEST_EXISTING_BOOK_ID);
    }

    @Test
    @DisplayName("test get all books")
    void testGetAllBooks() {
        List<Book> books = bookRepository.getAll();
        assertThat(books.size()).isGreaterThan(1);
        assertThat(books.size()).isEqualTo(TEST_EXPECTED_BOOKS_SIZE);
    }

    @Test
    @DisplayName("test update book")
    void testUpdateBook() {
        Book book = bookRepository.getById(TEST_EXISTING_BOOK_ID);
        book.setAuthorId(2);
        book.setGenreId(2);
        book.setBookName(TEST_NEW_BOOK_NAME);
        bookRepository.update(book);
        Book updatedBook = bookRepository.getById(TEST_EXISTING_BOOK_ID);
        assertThat(updatedBook.getAuthorId()).isEqualTo(2);
        assertThat(updatedBook.getGenreId()).isEqualTo(2);
        assertThat(updatedBook.getBookName()).isEqualTo(TEST_NEW_BOOK_NAME);
    }
}
