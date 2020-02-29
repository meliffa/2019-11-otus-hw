package ru.otus.hw.spring;

import com.github.cloudyrock.mongock.Mongock;
import com.github.cloudyrock.mongock.SpringMongockBuilder;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
@Configuration
public class ApplicationConfig {
    private static final String CHANGELOGS_PACKAGE = "ru.otus.hw.changelogs";

    @Bean
    public Mongock mongock(MongoProperties mongoProperties, MongoClient mongoClient) {
        return new SpringMongockBuilder(mongoClient, mongoProperties.getDatabase(), CHANGELOGS_PACKAGE)
                .build();
    }
}
