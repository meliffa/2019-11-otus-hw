package ru.otus.hw.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.hw.service.StarterProvider;

/**
 * Created by Inna Spodarik on 05.01.2020.
 */
@ShellComponent
public class ShellCommander {
    private final StarterProvider starterProvider;

    public ShellCommander(StarterProvider starterProvider) {
        this.starterProvider = starterProvider;
    }

    @ShellMethod(key = {"s", "start", "st"}, value = "start testing")
    public void doStartTest() {
        starterProvider.start();
    }
}
