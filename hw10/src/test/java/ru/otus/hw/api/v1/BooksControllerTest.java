package ru.otus.hw.api.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Inna Spodarik on 01.03.2020.
 */
@WebMvcTest(BooksController.class)
public class BooksControllerTest {
    public static final String BOOK_NAME = "451 градус по фаренгейту";
    public static final String GENRE_NAME = "Научная фантастика";
    public static final String AUTHOR_NAME = "Рэй Брэдбери";
    public static final String BOOKS_URL = "/books/v1";
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
        given(bookProvider.getAll()).willReturn(books);
    }

    @Test
    public void testGetBooks() throws Exception {
        mockMvc.perform(get(BOOKS_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
