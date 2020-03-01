package ru.otus.hw.service.book;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.jpa.entity.Book;
import ru.otus.hw.jpa.repository.book.BookRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
public class BookProviderImpl implements BookProvider {

    private final BookRepository bookRepository;

    public BookProviderImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void create(BookDTO book) {
        bookRepository.save(book.buildJpaEntity());
    }

    @Override
    public BookDTO getById(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book != null ? book.buildDTO() : null;
    }

    @Override
    public List<BookDTO> getByName(String name) {
        return bookRepository.findByBookName(name).stream()
                .map(a -> a.buildDTO())
                .collect(Collectors.toList());
    }

    @Override
    public void update(BookDTO book) {
        bookRepository.save(book.buildJpaEntity());
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDTO> getAll() {
        return bookRepository.findAll().stream()
                .map(a -> a.buildDTO())
                .sorted(Comparator.comparing(BookDTO::getBookId))
                .collect(Collectors.toList());
    }
}
