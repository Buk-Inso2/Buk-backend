package edu.pe.upao.buk.repositories;

import edu.pe.upao.buk.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>{
}
