package ru.otus.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@EnableFeignClients
@EnableDiscoveryClient
@EnableAutoConfiguration
@SpringBootApplication
public class HW18BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(HW18BooksApplication.class, args);
    }

}
