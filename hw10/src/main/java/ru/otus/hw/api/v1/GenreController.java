package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.dto.GenreDTO;
import ru.otus.hw.service.genre.GenreProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 29.02.2020.
 */
@RestController("GenreController_v1")
@RequestMapping("/genre/v1")
public class GenreController {
    private Logger logger = LogManager.getLogger();

    private final GenreProvider genreProvider;

    public GenreController(GenreProvider genreProvider) {
        this.genreProvider = genreProvider;
    }

    @PostMapping
    public void createGenre(@RequestBody GenreDTO genre) {
        genreProvider.create(genre);
    }
}
