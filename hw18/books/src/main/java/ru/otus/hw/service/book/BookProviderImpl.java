package ru.otus.hw.service.book;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.dto.CommentDTO;
import ru.otus.hw.jpa.entity.Book;
import ru.otus.hw.jpa.repository.book.BookRepository;
import ru.otus.hw.service.comment.CommentProvider;
import ru.otus.hw.service.samples.BookSamplesProvider;
import ru.otus.hw.utils.DtoJpaConverter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@Service
@RequiredArgsConstructor
public class BookProviderImpl implements BookProvider {
    private Logger logger = LogManager.getLogger();

    private final BookRepository bookRepository;
    private final DtoJpaConverter converter;
    private final BookSamplesProvider bookSamplesProvider;
    private final CommentProvider commentProvider;

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    /*@HystrixCommand(
            fallbackMethod = "getBooksSamples",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")}
    )*/
    public List<BookDTO> getAll() {
        List<BookDTO> books = bookRepository.findAll().stream()
                .map(b -> converter.convertToBookDto(b))
                .sorted(Comparator.comparing(BookDTO::getBookId))
                .collect(Collectors.toList());
        books.forEach(b -> {
            List<CommentDTO> comments = commentProvider.getBookComments(b.getBookId());
            b.setComments(comments);
        });
        return books;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getBookSample")
    public BookDTO getById(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book != null) {
            BookDTO bookDTO = converter.convertToBookDto(book);
            return bookDTO;
        } else {
            return null;
        }
    }

    @Override
    @HystrixCommand(fallbackMethod = "getAuthorBooksSamples")
    public List<BookDTO> getByAuthorId(Integer authorId) {
        List<BookDTO> books = bookRepository.findByAuthorId(authorId).stream()
                .map(b -> converter.convertToBookDto(b))
                .sorted(Comparator.comparing(BookDTO::getBookId))
                .collect(Collectors.toList());
        return books;
    }

    private List<BookDTO> getBooksSamples() {
        logger.error("Circuit breaker enabled, get samples books");
        return bookSamplesProvider.getBooksSamples();
    }

    private BookDTO getBookSample(Integer bookId) {
        logger.error("Circuit breaker enabled, get sample book");
        return bookSamplesProvider.getBookSample();
    }

    private List<BookDTO> getAuthorBooksSamples(Integer authorId) {
        logger.error("Circuit breaker enabled, get author samples books");
        return bookSamplesProvider.getAuthorBooksSamples();
    }
}
