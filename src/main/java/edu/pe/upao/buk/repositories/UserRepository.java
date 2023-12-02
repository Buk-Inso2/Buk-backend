package edu.pe.upao.buk.repositories;

import edu.pe.upao.buk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
