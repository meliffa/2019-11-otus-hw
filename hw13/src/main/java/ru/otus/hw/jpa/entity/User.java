package ru.otus.hw.jpa.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Inna Spodarik on 28.03.2020.
 */
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HW_USER")
public class User {
    @Id
    @Column(name = "USERID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;
}
