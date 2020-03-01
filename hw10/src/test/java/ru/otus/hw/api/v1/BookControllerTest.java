package ru.otus.hw.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.dto.GenreDTO;
import ru.otus.hw.service.author.AuthorProvider;
import ru.otus.hw.service.book.BookProvider;
import ru.otus.hw.service.genre.GenreProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static ru.otus.hw.api.v1.BookController.BOOKS_HTML;

/**
 * Created by Inna Spodarik on 29.02.2020.
 */
@WebMvcTest(BookController.class)
public class BookControllerTest {
    public static final String BOOK_NAME = "451 градус по фаренгейту";
    public static final String NEW_BOOK_NAME = "test";
    public static final String GENRE_NAME = "Научная фантастика";
    public static final String AUTHOR_NAME = "Рэй Брэдбери";
    public static final String BOOK_URL = "/book/v1";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookProvider bookProvider;
    @MockBean
    private AuthorProvider authorProvider;
    @MockBean
    private GenreProvider genreProvider;

    @BeforeEach
    void setUp(){
        List<BookDTO> books = new ArrayList<>();

        GenreDTO genre = new GenreDTO(1, GENRE_NAME);
        AuthorDTO author = new AuthorDTO(1, AUTHOR_NAME, new HashSet<>());
        BookDTO book = new BookDTO(1,
                BOOK_NAME,
                author,
                genre);

        books.add(book);
        given(bookProvider.getById(anyInt())).willReturn(book);
    }

    @Test
    public void testEditBook() throws Exception {
        GenreDTO genre = new GenreDTO(1, GENRE_NAME);
        AuthorDTO author = new AuthorDTO(1, AUTHOR_NAME, new HashSet<>());
        BookDTO book = new BookDTO(1,
                BOOK_NAME,
                author,
                genre);
        mockMvc.perform(
                    put(BOOK_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(book))
                )
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateBook() throws Exception {
        GenreDTO genre = new GenreDTO(1, GENRE_NAME);
        AuthorDTO author = new AuthorDTO(1, AUTHOR_NAME, new HashSet<>());
        BookDTO book = new BookDTO(null,
                BOOK_NAME,
                author,
                genre);
        mockMvc.perform(
                post(BOOK_URL)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(new ObjectMapper().writeValueAsString(book))
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete(BOOK_URL + "/2"))
                .andExpect(status().isOk());
    }
}
