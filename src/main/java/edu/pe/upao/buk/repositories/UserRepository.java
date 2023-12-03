package edu.pe.upao.buk.repositories;

import edu.pe.upao.buk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByDni(String dni);

    boolean existsByEmailOrDni(String email, String dni);

    Optional<User> findByEmail(String username);

    boolean existsByCellphone(String cellphone);
}
