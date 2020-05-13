package ru.otus.hw.jpa.entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Getter
@Setter
@EqualsAndHashCode(exclude={"book"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

}
