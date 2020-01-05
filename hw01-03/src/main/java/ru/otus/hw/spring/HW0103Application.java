package ru.otus.hw.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.hw.service.StarterProvider;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */

@SpringBootApplication(scanBasePackages = "ru.otus.hw")
public class HW0103Application implements CommandLineRunner {
    private final StarterProvider provider;

    public HW0103Application(StarterProvider provider) {
        this.provider = provider;
    }

    public static void main(String[] args) {
        SpringApplication.run(HW0103Application.class, args);
    }

    @Override
    public void run(String... args) {
        provider.start();
    }
}
