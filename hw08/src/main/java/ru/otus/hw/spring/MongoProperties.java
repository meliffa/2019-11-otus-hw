package ru.otus.hw.spring;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Inna Spodarik on 24.02.2020.
 */
@Data
@Component
@ConfigurationProperties("spring.data.mongodb")
public class MongoProperties {
    private int port;
    private String database;
    private String uri;
}

