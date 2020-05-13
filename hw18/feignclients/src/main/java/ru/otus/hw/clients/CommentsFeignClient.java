package ru.otus.hw.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.otus.hw.dto.CommentDTO;

import java.util.List;

/**
 * Created by Inna Spodarik on 11.05.2020.
 */
@FeignClient(name = "comments")
public interface CommentsFeignClient {

    @RequestMapping(method = RequestMethod.GET,
            path =  "/comments/book/{bookId}")
    List<CommentDTO> getCommentsByBookId(@PathVariable("bookId") Integer bookId);
}
