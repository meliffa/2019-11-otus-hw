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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.hw.db.entity.Author;
import ru.otus.hw.service.author.AuthorProvider;
import ru.otus.hw.spring.HW11Application;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
/**
 * Created by Inna Spodarik on 12.05.2020.
 */
@DisplayName("Test author controller")
@SpringBootTest(classes = HW11Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private AuthorProvider authorProvider;

    public static final String TEST_AUTHOR_NAME = "Albert Camus";

    @BeforeEach
    void setUp(){
        Author author = new Author(TEST_AUTHOR_NAME);

        List<Author> authors = new ArrayList<>();
        authors.add(author);

        Mono<Author> authorMono = Mono.just(author);
        Flux<Author> authorFlux = Flux.fromIterable(authors);

        Mockito.when(authorProvider.getByName(anyString())).thenReturn(authorMono);
        Mockito.when(authorProvider.getAll()).thenReturn(authorFlux);
    }

    @Test
    void testGetAuthors() {
        webTestClient.get().uri("/authors/v1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testGetAuthorByName() {
        webTestClient.get().uri("/author/v1/" + TEST_AUTHOR_NAME)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }
}
