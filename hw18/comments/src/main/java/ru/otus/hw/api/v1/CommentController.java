package ru.otus.hw.api.v1;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.hw.dto.CommentDTO;
import ru.otus.hw.service.CommentProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 11.05.2020.
 */
@RequestMapping("/comments")
@Controller("CommentController_v1")
@RequiredArgsConstructor
public class CommentController {
    private Logger logger = LogManager.getLogger();

    private final CommentProvider commentProvider;

    @GetMapping("/book/{bookId}")
    public ResponseEntity<?> getByBookId(@PathVariable Integer bookId) {
        try {
            List<CommentDTO> comments = commentProvider.getByBookId(bookId);
            return ResponseEntity.status(HttpStatus.OK).body(comments);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
