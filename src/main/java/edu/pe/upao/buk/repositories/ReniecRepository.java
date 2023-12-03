package edu.pe.upao.buk.repositories;

import edu.pe.upao.buk.models.Reniec;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReniecRepository extends JpaRepository<Reniec, Long> {
    Reniec findByDni(String dni);
}
