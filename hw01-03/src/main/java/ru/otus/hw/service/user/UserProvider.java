package ru.otus.hw.service.user;

import ru.otus.hw.entity.User;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
public interface UserProvider {
    User createUser(String name, String surname);
}
