package edu.pe.upao.buk.repositories;

import edu.pe.upao.buk.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
