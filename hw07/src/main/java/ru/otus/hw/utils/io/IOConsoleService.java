package ru.otus.hw.utils.io;

import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * Created by Inna Spodarik on 04.01.2020.
 */
@Service
public class IOConsoleService implements IOProvider {
    private final Scanner sc;

    public IOConsoleService() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public String read() {
        return sc.nextLine();
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
