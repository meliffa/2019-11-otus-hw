package ru.otus.hw.jpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw.jpa.entity.User;

import java.util.Optional;

/**
 * Created by Inna Spodarik on 28.03.2020.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(String login);
}

