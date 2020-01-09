package ru.otus.hw.utils.messages;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.hw.utils.ApplicationProperties;

import java.util.Locale;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */

@Service
public class MessageImpl implements MessageProvider {
    private final MessageSource messageSource;
    private ApplicationProperties applicationProperties;
    private Locale locale;

    public MessageImpl(MessageSource messageSource, ApplicationProperties applicationProperties) {
        this.messageSource = messageSource;
        this.applicationProperties = applicationProperties;
        this.locale = applicationProperties.getLocale();
    }

    public String getMessage(String message) {
        return messageSource.getMessage(message, null, locale);
    }

    public String getFormattedMessage(String message, Object... args) {
        return messageSource.getMessage(message, args, locale);
    }
}
