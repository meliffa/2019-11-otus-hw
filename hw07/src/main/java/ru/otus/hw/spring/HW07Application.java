package ru.otus.hw.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@SpringBootApplication(scanBasePackages = "ru.otus.hw")
@EntityScan("ru.otus.hw")
@EnableJpaRepositories(basePackages = {"ru.otus.hw.jpa.repository"})
public class HW07Application {

    public static void main(String[] args) {
        SpringApplication.run(HW07Application.class, args);
    }

}
