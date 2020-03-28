package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.dto.GenreDTO;
import ru.otus.hw.service.book.BookProvider;
import ru.otus.hw.service.genre.GenreProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 01.03.2020.
 */
@RestController("GenresController_v1")
@RequestMapping("/genres/v1")
public class GenresController {
    private Logger logger = LogManager.getLogger();

    private final GenreProvider genreProvider;

    public GenresController(GenreProvider provider) {
        this.genreProvider = provider;
    }

    @GetMapping
    public List<GenreDTO> getGenres() {
        return genreProvider.getAll();
    }
}
