package ru.otus.hw.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

/**
 * Created by Inna Spodarik on 28.03.2020.
 */
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().disable().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/author/add", "/author/save").hasAuthority("ADMIN")
                .antMatchers("/authors").hasAnyAuthority("ADMIN", "USER")

                .antMatchers("/book/edit/*", "/book/save", "book/add", "book/delete/*").hasAuthority("ADMIN")
                .antMatchers("/books").hasAnyAuthority("ADMIN", "USER")

                .antMatchers("/genre/add", "/genre/save").hasAuthority("ADMIN")
                .antMatchers("/genres").hasAnyAuthority("ADMIN", "USER")

                .antMatchers(
                        "/actuator/**",
                        "/metrics/**").permitAll()

                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("login")
                .and()
                .logout()
                .logoutUrl("/logout");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
