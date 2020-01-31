package ru.otus.hw.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */

@Data
@Configuration
@ConfigurationProperties("hw")
public class ApplicationProperties {
    public static final String CSV_EXT = ".csv";

    private String lang;
    private String guestName;
    private String guestSurname;
    private String filePath;
    private String questionsFilePrefix;
    private String answersFilePrefix;
    private String fileDelimiter;

    public Locale getLocale() {
        return new Locale(lang);
    }

    public String getQuestionsFileName() {
        return filePath + questionsFilePrefix + getLang() + CSV_EXT;
    }

    public String getAnswersFileName() {
        return filePath + answersFilePrefix + getLang() + CSV_EXT;
    }

}
