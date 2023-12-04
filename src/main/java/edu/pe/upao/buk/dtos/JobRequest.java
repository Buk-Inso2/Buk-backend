package edu.pe.upao.buk.dtos;

import edu.pe.upao.buk.models.Benefit;
import edu.pe.upao.buk.models.Responsibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
    private String workArea;
    private int salary;
    private String shift;
    private List<ResponsibilityRequest> responsibilities;
    private List<BenefitRequest> benefits;
}