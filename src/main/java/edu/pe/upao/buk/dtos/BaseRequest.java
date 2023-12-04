package edu.pe.upao.buk.dtos;

import edu.pe.upao.buk.models.Evaluator;
import edu.pe.upao.buk.models.Requirement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest {
    private LocalDate startDate;
    private LocalDate deadLine;
    private LocalDate interviewDate;
    private LocalDate candidateAnnouncement;

    private List<RequirementRequest> requirements;
    private List<EvaluatorRequest> evaluators;
    // Getters y setters
}
