package ru.fsab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fsab.models.Role;
import ru.fsab.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    List<User> findAllByRole(Role role);
//    User findByLogin(String login);
    Optional<User> findOneByLogin(String login);
}
