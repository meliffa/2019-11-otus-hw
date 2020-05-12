package ru.otus.hw.spring;

import com.github.cloudyrock.mongock.SpringBootMongock;
import com.github.cloudyrock.mongock.SpringBootMongockBuilder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@ConfigurationProperties("spring.data.mongodb")
@Data
public class MongoConfig {

    private static final String CHANGELOGS_PACKAGE = "ru.otus.hw.changelogs";
    private final MongoProperties mongoProperties;
    @Bean
    public SpringBootMongock mongock(ApplicationContext springContext, com.mongodb.MongoClient mongoClient) {
        return new SpringBootMongockBuilder(mongoClient, mongoProperties.getDatabase(), CHANGELOGS_PACKAGE)
                .setApplicationContext(springContext)
                .setLockQuickConfig()
                .build();
    }
}
