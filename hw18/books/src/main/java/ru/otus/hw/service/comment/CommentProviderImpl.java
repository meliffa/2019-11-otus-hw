package ru.otus.hw.service.comment;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.otus.hw.clients.CommentsFeignClient;
import ru.otus.hw.dto.CommentDTO;
import ru.otus.hw.service.samples.BookSamplesProvider;
import ru.otus.hw.service.samples.CommentSamplesProvider;

import java.util.List;

/**
 * Created by Inna Spodarik on 11.05.2020.
 */
@Service
@RequiredArgsConstructor
public class CommentProviderImpl implements CommentProvider {
    private Logger logger = LogManager.getLogger();

    private final CommentsFeignClient commentsFeignClient;
    private final CommentSamplesProvider commentSamplesProvider;

    @Override
    @HystrixCommand(fallbackMethod = "getCommentsSamples")
    public List<CommentDTO> getBookComments(Integer bookId) {
        List<CommentDTO> comments = commentsFeignClient.getCommentsByBookId(bookId);
        return comments;
    }

    private List<CommentDTO> getCommentsSamples(Integer bookId) {
        logger.error("Circuit breaker enabled, get comments samples");
        return commentSamplesProvider.getCommentsSamples(bookId);
    }
}
