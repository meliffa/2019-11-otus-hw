package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.otus.hw.dto.AuthorDTO;
import ru.otus.hw.dto.GenreDTO;
import ru.otus.hw.service.genre.GenreProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 29.02.2020.
 */
@Controller("GenreController_v1")
public class GenreController {
    private Logger logger = LogManager.getLogger();

    private final GenreProvider genreProvider;
    public static final String GENRES_HTML = "genres";
    public static final String GENRES_EDIT_HTML = "genreEdit";

    public GenreController(GenreProvider genreProvider) {
        this.genreProvider = genreProvider;
    }

    @GetMapping("/genres")
    public String getGenres(Model model) {
        List<GenreDTO> genres = genreProvider.getAll();
        model.addAttribute("genres", genres);
        return GENRES_HTML;
    }

    @GetMapping("/genre/add")
    public String addGenre(Model model) {
        model.addAttribute("genre", new GenreDTO());
        return GENRES_EDIT_HTML;
    }

    @PostMapping("/genre/save")
    public String saveGenre(@ModelAttribute GenreDTO genre) {
        if (genre.getGenreId() != null) {
            genreProvider.update(genre);
        } else {
            genreProvider.create(genre);
        }
        return "redirect:/" + GENRES_HTML;
    }
}
