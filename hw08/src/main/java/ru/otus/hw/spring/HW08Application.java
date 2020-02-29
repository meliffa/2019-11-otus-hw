package ru.otus.hw.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@SpringBootApplication(scanBasePackages = "ru.otus.hw")
@EntityScan("ru.otus.hw")
@EnableMongoRepositories(basePackages = {"ru.otus.hw.db"})
@EnableConfigurationProperties
public class HW08Application {

    public static void main(String[] args) {
        SpringApplication.run(HW08Application.class, args);
    }

}
