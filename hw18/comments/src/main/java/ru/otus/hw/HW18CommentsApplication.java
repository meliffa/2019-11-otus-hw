package ru.otus.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@SpringBootApplication
public class HW18CommentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HW18CommentsApplication.class, args);
    }

}
