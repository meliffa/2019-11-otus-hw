package ru.otus.hw.jpa.repository.userrole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.hw.jpa.entity.UserRole;

import java.util.List;

/**
 * Created by Inna Spodarik on 28.03.2020.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUserId(Integer userId);
}