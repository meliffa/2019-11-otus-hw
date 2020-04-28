package ru.otus.hw.spring.metrics;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;
import ru.otus.hw.jpa.repository.author.AuthorRepository;
import ru.otus.hw.jpa.repository.book.BookRepository;
import ru.otus.hw.jpa.repository.genre.GenreRepository;
import ru.otus.hw.jpa.repository.role.RoleRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Inna Spodarik on 28.04.2020.
 */
@RequiredArgsConstructor
@Component
public class DataHealthCheckIndicator implements HealthIndicator {
    private static final String USER_ROLE = "USER";
    private static final String ERROR = "error";
    private static final String DATA_ERROR_MESSAGE = "Data is absent in db";
    private final RoleRepository roleRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Override
    public Health health() {
        Map<String, Object> details = getDetails();
        if (!details.isEmpty()) {
            return Health.up()
                    .status(Status.UP)
                    .withDetails(details)
                    .build();
        } else {
            return Health.outOfService()
                    .status(Status.OUT_OF_SERVICE)
                    .withDetail(ERROR, DATA_ERROR_MESSAGE)
                    .build();
        }
    }

    private Map<String, Object> getDetails() {
        Map<String, Object> details = new HashMap<>();

        long roleCount = roleRepository.count();
        if (roleCount > 0) {
            details.put("roleCount", roleCount);
        }

        long authorCount = authorRepository.count();
        if (authorCount > 0) {
            details.put("authorCount", authorCount);
        }

        long genreCount = genreRepository.count();
        if (genreCount > 0) {
            details.put("genreCount", genreCount);
        }

        long bookCount = bookRepository.count();
        if (bookCount > 0) {
            details.put("bookCount", bookCount);
        }

        return details;
    }
}
