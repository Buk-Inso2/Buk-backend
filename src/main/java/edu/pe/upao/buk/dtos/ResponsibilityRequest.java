package edu.pe.upao.buk.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsibilityRequest {
    private String responsibilityText;

    public String getResponsibilityText() {
        return responsibilityText;
    }

    public void setResponsibilityText(String responsibilityText) {
        this.responsibilityText = responsibilityText;
    }
}
