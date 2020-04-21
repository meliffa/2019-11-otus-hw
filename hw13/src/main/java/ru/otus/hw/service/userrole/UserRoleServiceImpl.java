package ru.otus.hw.service.userrole;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import ru.otus.hw.jpa.entity.UserRole;
import ru.otus.hw.jpa.repository.userrole.UserRoleRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Inna Spodarik on 28.03.2020.
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public List<? extends GrantedAuthority> getUserAuthorities(Integer userId) {
        List<UserRole> userRoles = userRoleRepository.findByUserId(userId);

        return userRoles.stream()
                .map(userRole -> new SimpleGrantedAuthority(userRole.getRole().getRoleSysName()))
                .collect(Collectors.toList());
    }
}
