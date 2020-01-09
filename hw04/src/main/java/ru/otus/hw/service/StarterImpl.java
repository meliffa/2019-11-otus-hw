package ru.otus.hw.service;

import org.springframework.stereotype.Service;
import ru.otus.hw.service.test.TestMakerProvider;
import ru.otus.hw.service.test.TestProvider;
import ru.otus.hw.service.user.UserMakerProvider;
/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Service
public class StarterImpl implements StarterProvider {
    private final UserMakerProvider userMakerProvider;
    private final TestMakerProvider testMakerProvider;
    private final TestProvider testProvider;

    public StarterImpl(UserMakerProvider userMakerProvider, TestMakerProvider testMakerProvider,
                       TestProvider testProvider) {
        this.userMakerProvider = userMakerProvider;
        this.testMakerProvider = testMakerProvider;
        this.testProvider = testProvider;
    }

    @Override
    public void start() {
        testProvider.doTest(testMakerProvider.makeTest(userMakerProvider.makeUser()));
    }
}
