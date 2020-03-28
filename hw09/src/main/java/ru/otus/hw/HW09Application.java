package ru.otus.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@SpringBootApplication
public class HW09Application {

    public static void main(String[] args) {
        SpringApplication.run(HW09Application.class, args);
    }

}
