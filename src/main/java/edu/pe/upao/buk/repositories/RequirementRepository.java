package edu.pe.upao.buk.repositories;

import edu.pe.upao.buk.models.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementRepository extends JpaRepository<Requirement,Long> {
}
