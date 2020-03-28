package ru.otus.hw.spring;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Inna Spodarik on 28.03.2020.
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
