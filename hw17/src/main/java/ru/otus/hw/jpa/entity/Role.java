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
@Table(name="HW_ROLE")
public class Role {
    @Id
    @Column(name = "ROLEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(name = "ROLESYSNAME")
    private String roleSysName;
}
