package ru.otus.hw.api.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public static final String URL_AFTER_SAVE_BOOK = "redirect:/" + BOOKS_HTML;;
    public static final String GENRE_NAME = "Научная фантастика";
    public static final String AUTHOR_NAME = "Рэй Брэдбери";
    public static final String ADMIN_USER = "admin";
    public static final String ADMIN_ROLE = "ADMIN";
    public static final String USER = "user";
    public static final String USER_ROLE = "USER";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookProvider bookProvider;
    @MockBean
    private AuthorProvider authorProvider;
    @MockBean
    private GenreProvider genreProvider;
    @MockBean
    private UserDetailsService userDetailsService;

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
        given(bookProvider.getAll()).willReturn(books);
    }

    @Test
    @WithMockUser(username = USER, authorities = {USER_ROLE})
    public void testGetBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("books"));
    }

    @Test
    @WithMockUser(username = ADMIN_USER, authorities = {ADMIN_ROLE})
    public void testEditBook() throws Exception {
        mockMvc.perform(get("/book/edit/1"))
                .andExpect(model().attributeExists("book"))
                .andExpect(model().attributeExists("authors"))
                .andExpect(model().attributeExists("genres"))
                .andExpect(status().isOk())
                .andExpect(view().name(BookController.BOOK_EDIT_HTML));
    }

    @Test
    @WithMockUser(username = ADMIN_USER, authorities = {ADMIN_ROLE})
    public void testSaveBook() throws Exception {
        mockMvc.perform(post("/book/save")
                .param("bookName", "Test"))
                .andExpect(view().name(URL_AFTER_SAVE_BOOK));
    }

    @Test
    @WithMockUser(username = ADMIN_USER, authorities = {ADMIN_ROLE})
    public void testAddBook() throws Exception {
        mockMvc.perform(get("/book/add"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("book"))
                .andExpect(model().attributeExists("authors"))
                .andExpect(model().attributeExists("genres"))
                .andExpect(view().name(BookController.BOOK_EDIT_HTML));
    }

    @Test
    @WithMockUser(username = ADMIN_USER, authorities = {ADMIN_ROLE})
    public void testDeleteBook() throws Exception {
        mockMvc.perform(get("/book/delete/1"))
                .andExpect(view().name(URL_AFTER_SAVE_BOOK));
    }
}
