package ru.otus.hw.jpa.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Inna Spodarik on 28.03.2020.
 */
@Getter
@Setter
@EqualsAndHashCode(exclude={"user", "role"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HW_USER_ROLE")
public class UserRole {
    @Id
    @Column(name = "USERROLEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRoleId;

    @Column(name = "ROLEID")
    private Integer roleId;

    @Column(name = "USERID")
    private Integer userId;

    @OneToOne(targetEntity = Role.class, fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name="ROLEID", insertable = false, updatable = false)
    private Role role;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name="USERID", insertable = false, updatable = false)
    private User user;
}
