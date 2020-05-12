package ru.otus.hw.api.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Author;
import ru.otus.hw.db.entity.Book;
import ru.otus.hw.db.entity.Genre;
import ru.otus.hw.service.book.BookProvider;
import ru.otus.hw.spring.HW11Application;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by Inna Spodarik on 12.05.2020.
 */
@DisplayName("Test book controller")
@SpringBootTest(classes = HW11Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private BookProvider bookProvider;

    private static final String TEST_BOOK_NAME = "Plague";
    private static final String TEST_GENRE_NAME = "Philosophical novel";
    public static final String TEST_BOOK_ID = "89832a66-4dc1-4979-b3ff-e04623719bea";

    @BeforeEach
    void setUp(){
        Author author = new Author(AuthorControllerTest.TEST_AUTHOR_NAME);
        Genre genre = new Genre(TEST_GENRE_NAME);
        Book book = new Book(TEST_BOOK_ID, TEST_BOOK_NAME, author, genre);

        List<Book> books = new ArrayList<>();
        books.add(book);

        Mono<Book> bookMono = Mono.just(book);
        Flux<Book> bookFlux = Flux.fromIterable(books);

        Mockito.when(bookProvider.getAll()).thenReturn(bookFlux);
        Mockito.when(bookProvider.getByName(anyString())).thenReturn(bookFlux);
        Mockito.when(bookProvider.getById(anyString())).thenReturn(bookMono);
        Mockito.when(bookProvider.create(any())).thenReturn(bookMono);
        Mockito.when(bookProvider.update(any())).thenReturn(bookMono);
        Mockito.when(bookProvider.deleteById(anyString())).thenReturn(Mono.empty());
    }

    @Test
    void testGetBooks() {
        webTestClient.get().uri("/books/v1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectStatus().isOk();
    }

    @Test
    void testGetBooksByName() {
        webTestClient.get().uri("/book/v1/" + TEST_BOOK_NAME)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testCreateBook() {
        Author author = new Author(AuthorControllerTest.TEST_AUTHOR_NAME);
        Genre genre = new Genre(TEST_GENRE_NAME);
        Book book = new Book(TEST_BOOK_ID, TEST_BOOK_NAME, author, genre);

        webTestClient.post().uri("/book/v1")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(book), BodyInserter.class)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateBook() {
        Author author = new Author(AuthorControllerTest.TEST_AUTHOR_NAME);
        Genre genre = new Genre(TEST_GENRE_NAME);
        Book book = new Book(TEST_BOOK_ID, TEST_BOOK_NAME, author, genre);

        webTestClient.put().uri("/book/v1")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(book), BodyInserter.class)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testDeleteBook() {
        webTestClient.delete().uri("/book/v1/" + TEST_BOOK_ID)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

}
