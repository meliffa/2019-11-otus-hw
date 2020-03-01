package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.service.author.AuthorProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 29.02.2020.
 */
@RestController("AuthorController_v1")
@RequestMapping("/author/v1")
public class AuthorController {
    private Logger logger = LogManager.getLogger();

    private final AuthorProvider authorProvider;

    public AuthorController(AuthorProvider authorProvider) {
        this.authorProvider = authorProvider;
    }

    @PostMapping
    public void createAuthor(@RequestBody AuthorDTO author) {
        authorProvider.create(author);
    }
}
