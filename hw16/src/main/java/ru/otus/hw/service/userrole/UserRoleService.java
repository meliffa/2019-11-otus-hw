package ru.otus.hw.service.userrole;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * Created by Inna Spodarik on 28.03.2020.
 */
public interface UserRoleService {
    List<? extends GrantedAuthority> getUserAuthorities(Integer userId);
}
