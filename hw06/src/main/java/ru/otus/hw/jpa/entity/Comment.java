package ru.otus.hw.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import ru.otus.hw.dto.BookDTO;
import ru.otus.hw.dto.CommentDTO;

import javax.persistence.*;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="HW_COMMENT")
public class Comment {
    @Id
    @Column(name = "COMMENTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "COMMENT", length = 4000)
    private String comment;

    @Column(name = "BOOKID")
    private Integer bookId;

    @ManyToOne(targetEntity = Book.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOKID", insertable = false, updatable = false)
    @BatchSize(size = 10)
    private Book book;

    public CommentDTO buildDTO() {
        return CommentDTO.builder()
                .commentId(commentId)
                .comment(comment)
                .book(book.buildDTO())
                .build();
    }
}
