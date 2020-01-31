package ru.otus.hw.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */

@SpringBootApplication(scanBasePackages = "ru.otus.hw")
public class HW05Application {

    public static void main(String[] args) {
        SpringApplication.run(HW05Application.class, args);
    }

}
