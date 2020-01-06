package ru.otus.hw.jpa.entity;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.otus.hw.dto.AuthorDTO;

import javax.persistence.*;

/**
 * Created by Inna Spodarik on 06.01.2020.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="HW_AUTHOR")
public class Author {
    @Id
    @Column(name = "AUTHORID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    @Column(name = "AUTHORNAME", length = 1024)
    private String authorName;

    public AuthorDTO buildDTO() {
        return AuthorDTO.builder()
                .authorId(authorId)
                .authorName(authorName)
                .build();
    }
}
