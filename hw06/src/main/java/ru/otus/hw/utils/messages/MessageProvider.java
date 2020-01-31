package ru.otus.hw.utils.messages;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
public interface MessageProvider {
    String getMessage(String key);
    String getFormattedMessage(String key, String... args);
}
