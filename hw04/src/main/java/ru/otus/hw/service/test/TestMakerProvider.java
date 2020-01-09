package ru.otus.hw.service.test;

import ru.otus.hw.entity.Test;
import ru.otus.hw.entity.User;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
public interface TestMakerProvider {
    Test makeTest(User user);
}
