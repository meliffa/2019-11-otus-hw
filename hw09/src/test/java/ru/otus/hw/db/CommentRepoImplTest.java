package ru.otus.hw.db;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.hw.jpa.entity.Comment;
import ru.otus.hw.jpa.repository.comment.CommentRepository;
import ru.otus.hw.HW09Application;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@DisplayName("Test comment repository")
@SpringBootTest(classes = HW09Application.class)
public class CommentRepoImplTest {
    public static final String TEST_NEW_COMMENT_TEXT = "test comment";
    public static final Integer TEST_EXISTING_COMMENT_ID = 1;
    public static final String TEST_EXISTING_COMMENT_TEST = "451 градус по фаренгейту, Рэй Брэдбери";
    public static final Integer TEST_NEW_COMMENT_ID = 7;
    public static final Integer TEST_EXISTING_BOOK_ID = 1;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    @DisplayName("test create comment")
    void testCreateComment() {
        Comment comment = Comment.builder()
                .bookId(TEST_EXISTING_BOOK_ID)
                .comment(TEST_NEW_COMMENT_TEXT)
                .build();
        commentRepository.save(comment);
        Comment createdComment = commentRepository.findById(TEST_NEW_COMMENT_ID).orElse(Comment.builder().build());
        assertEquals(createdComment.getComment(), TEST_NEW_COMMENT_TEXT);
    }

    @Test
    @DisplayName("test get comment by id")
    void testGetCommentById() {
        Comment comment = commentRepository.findById(TEST_EXISTING_COMMENT_ID).orElse(Comment.builder().build());
        assertEquals(comment.getComment(), TEST_EXISTING_COMMENT_TEST);
    }

    @Test
    @DisplayName("test get comment by book id")
    void testGetCommentByBookId() {
        List<Comment> comments = commentRepository.findByBookId(TEST_EXISTING_BOOK_ID);
        assertNotNull(comments);
        assertEquals(comments.size(), 1);
    }
}
