package ru.otus.hw.service.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.hw.entity.User;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@DisplayName("UserImpl test")
public class UserImplTest {

    @Test
    @DisplayName("Test creating")
    void testConstructorCreation() {
        User user = new User("John", "Doe");
        assertAll(
                () -> assertEquals("John", user.getName()),
                () -> assertEquals("Doe", user.getSurname())
        );
    }

    @Test
    @DisplayName("Test setters")
    void testSetters() {
        User user = new User("John", "Doe");
        user.setName("no");
        user.setSurname("name");
        assertAll(
                () -> assertEquals("no", user.getName()),
                () -> assertEquals("name", user.getSurname())
        );
    }
}
