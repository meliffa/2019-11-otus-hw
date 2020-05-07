package ru.otus.hw.jpa.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw.jpa.entity.Role;
import java.util.Optional;

/**
 * Created by Inna Spodarik on 28.04.2020.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleSysName(String roleSysName);
}