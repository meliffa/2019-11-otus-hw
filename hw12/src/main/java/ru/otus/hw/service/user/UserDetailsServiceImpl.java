package ru.otus.hw.service.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.otus.hw.jpa.entity.User;
import ru.otus.hw.jpa.repository.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna Spodarik on 28.03.2020.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(userName).orElseThrow(() ->
                new UsernameNotFoundException("User not found by login: " + userName)
        );
        return convertUserToUserDetails(user);
    }

    private UserDetails convertUserToUserDetails(User user) {
        List<? extends GrantedAuthority> authorities = new ArrayList<>();
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                authorities
        );
        return userDetails;
    }
}
