package ru.otus.hw.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@SpringBootApplication(scanBasePackages = "ru.otus.hw")
@EntityScan("ru.otus.hw")
public class HW06Application {

    public static void main(String[] args) {
        SpringApplication.run(HW06Application.class, args);
    }

}
