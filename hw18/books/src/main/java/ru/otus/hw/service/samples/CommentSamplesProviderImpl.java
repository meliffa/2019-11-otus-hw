package ru.otus.hw.service.samples;

import org.springframework.stereotype.Service;
import ru.otus.hw.dto.CommentDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna Spodarik on 11.05.2020.
 */
@Service
public class CommentSamplesProviderImpl implements CommentSamplesProvider {

    public static final String TEST_COMMENT = "Test comment";

    @Override
    public List<CommentDTO> getCommentsSamples(Integer bookId) {
        CommentDTO comment = new CommentDTO(1, bookId, TEST_COMMENT);
        List<CommentDTO> comments = new ArrayList<>();
        comments.add(comment);
        return comments;
    }
}
