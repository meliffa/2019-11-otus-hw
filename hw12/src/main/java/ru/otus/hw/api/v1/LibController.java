package ru.otus.hw.api.v1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Inna Spodarik on 29.02.2020.
 */
@Controller("LibController_v1")
public class LibController {
    public static final String LIB_HTML = "lib";
    private Logger logger = LogManager.getLogger();

    @GetMapping
    public String viewLibrary() {
        return LIB_HTML;
    }
}
