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
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.service.author.AuthorProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 29.02.2020.
 */
@Controller("AuthorController_v1")
public class AuthorController {
    private Logger logger = LogManager.getLogger();

    private final AuthorProvider authorProvider;
    public static final String AUTHORS_HTML = "authors";
    public static final String AUTHOR_EDIT_HTML = "authorEdit";

    public AuthorController(AuthorProvider authorProvider) {
        this.authorProvider = authorProvider;
    }

    @GetMapping("/authors")
    public String getAuthors(Model model) {
        List<AuthorDTO> authors = authorProvider.getAll();
        model.addAttribute("authors", authors);
        return AUTHORS_HTML;
    }

    @GetMapping("/author/add")
    public String addAuthor(Model model) {
        model.addAttribute("author", new AuthorDTO());
        return AUTHOR_EDIT_HTML;
    }

    @PostMapping("/author/save")
    public String saveAuthor(@ModelAttribute AuthorDTO author) {
        if (author.getAuthorId() != null) {
            authorProvider.update(author);
        } else {
            authorProvider.create(author);
        }
        return "redirect:/" + AUTHORS_HTML;
    }
}
