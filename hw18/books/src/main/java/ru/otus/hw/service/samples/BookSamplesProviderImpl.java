package ru.otus.hw.service.samples;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.dto.GenreDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna Spodarik on 11.05.2020.
 */
@Service
public class BookSamplesProviderImpl implements BookSamplesProvider {
    public static final String SAMPLE_BOOK_NAME = "Чума";
    public static final String SAMPLE_AUTHOR_NAME = "Альбер Камю";
    public static final String SAMPLE_GENRE_NAME = "Философский роман";

    public static final String SAMPLE_TEST_AUTHOR_NAME = "Тестовый автор";
    public static final String SAMPLE_TEST_GENRE_NAME = "Тестовый жанр";
    public static final String SAMPLE_TEST_BOOK_NAME = "Тестовая книга";

    private AuthorDTO author = AuthorDTO.builder()
            .authorId(1)
            .authorName(SAMPLE_AUTHOR_NAME)
            .build();

    private GenreDTO genre = GenreDTO.builder()
            .genreId(1)
            .genreName(SAMPLE_GENRE_NAME)
            .build();


    @Override
    public List<BookDTO> getBooksSamples() {
        BookDTO book = BookDTO.builder()
                .bookId(1)
                .bookName(SAMPLE_BOOK_NAME)
                .genre(genre)
                .author(author)
                .build();

        List<BookDTO> books = new ArrayList<>();
        books.add(book);
        return books;
    }

    public BookDTO getBookSample() {
        BookDTO book = BookDTO.builder()
                .bookId(1)
                .bookName(SAMPLE_BOOK_NAME)
                .genre(genre)
                .author(author)
                .build();
        return book;
    }

    @Override
    public List<BookDTO> getAuthorBooksSamples() {
        AuthorDTO author = AuthorDTO.builder()
                .authorId(1)
                .authorName(SAMPLE_TEST_AUTHOR_NAME)
                .build();

        GenreDTO genre = GenreDTO.builder()
                .genreId(1)
                .genreName(SAMPLE_TEST_GENRE_NAME)
                .build();

        BookDTO book = BookDTO.builder()
                .bookId(1)
                .bookName(SAMPLE_TEST_BOOK_NAME)
                .genre(genre)
                .author(author)
                .build();

        List<BookDTO> authorBooks = new ArrayList<>();
        authorBooks.add(book);
        return authorBooks;
    }
}
