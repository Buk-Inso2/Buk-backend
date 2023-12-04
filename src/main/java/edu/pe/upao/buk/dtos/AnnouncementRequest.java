package edu.pe.upao.buk.dtos;

import edu.pe.upao.buk.models.Base;
import edu.pe.upao.buk.models.Form;
import edu.pe.upao.buk.models.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementRequest {
    private int vacancies;

    private Base base;
    private Form form;
    private Job job;
    // Getters y setters
}
