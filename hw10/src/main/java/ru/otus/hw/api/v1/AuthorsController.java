package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.service.author.AuthorProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 01.03.2020.
 */
@RestController("AuthorsController_v1")
@RequestMapping("/authors/v1")
public class AuthorsController {
    private Logger logger = LogManager.getLogger();

    private final AuthorProvider provider;
    public AuthorsController(AuthorProvider provider) {
        this.provider = provider;
    }

    @GetMapping
    public List<AuthorDTO> getAuthors() {
        return provider.getAll();
    }

}
