package ru.otus.hw.jpa.entity;

import lombok.*;
import ru.otus.hw.dto.BookDTO;

import javax.persistence.*;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */

@Getter
@Setter
@EqualsAndHashCode(exclude={"author", "genre"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HW_BOOK")
public class Book {
    @Id
    @Column(name = "BOOKID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(name = "BOOKNAME")
    private String bookName;

    @Column(name = "AUTHORID")
    private Integer authorId;

    @Column(name = "GENREID")
    private Integer genreId;

    @OneToOne(targetEntity = Author.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="AUTHORID", insertable = false, updatable = false)
    private Author author;

    @OneToOne(targetEntity = Genre.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="GENREID", insertable = false, updatable = false)
    private Genre genre;


}
