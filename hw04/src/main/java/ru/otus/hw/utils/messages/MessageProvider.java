package ru.otus.hw.utils.messages;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
public interface MessageProvider {
    String getMessage(String message);
    String getFormattedMessage(String message, Object... args);
}
