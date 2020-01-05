package ru.otus.hw.service.user;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.otus.hw.entity.User;
import ru.otus.hw.utils.ApplicationProperties;
import ru.otus.hw.utils.io.IOProvider;
import ru.otus.hw.utils.messages.MessageProvider;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */

@Service
public class UserMakerImpl implements UserMakerProvider {
    private final ApplicationProperties properties;
    private final IOProvider ioProvider;
    private final MessageProvider messageProvider;
    private final UserProvider userProvider;

    public UserMakerImpl(ApplicationProperties properties, IOProvider ioProvider,
                         MessageProvider messageProvider, UserProvider userProvider) {
        this.properties = properties;
        this.ioProvider = ioProvider;
        this.messageProvider = messageProvider;
        this.userProvider = userProvider;
    }

    public User makeUser() {
        ioProvider.print("=============================================================================");
        ioProvider.print(messageProvider.getMessage("HW.EnterUserName"));
        String userName = ioProvider.read();
        if (StringUtils.isEmpty(userName)) userName = properties.getGuestName();

        ioProvider.print(messageProvider.getMessage("HW.EnterUserSurname"));
        String userSurname = ioProvider.read();
        if (StringUtils.isEmpty(userSurname)) userSurname = properties.getGuestSurname();

        return userProvider.createUser(userName, userSurname);
    }
}
