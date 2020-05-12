package ru.otus.hw.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@SpringBootApplication(scanBasePackages = "ru.otus.hw")
@EntityScan("ru.otus.hw")
@EnableReactiveMongoRepositories(basePackages = {"ru.otus.hw.db"})
@EnableConfigurationProperties
public class HW11Application {

    public static void main(String[] args) {
        SpringApplication.run(HW11Application.class, args);
    }

}
