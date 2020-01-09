package ru.otus.hw.service.user;

import org.springframework.stereotype.Service;
import ru.otus.hw.entity.User;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Service
public class UserImpl implements UserProvider {

    public User createUser(String name, String surname) {
        return new User(name, surname);
    }

}
