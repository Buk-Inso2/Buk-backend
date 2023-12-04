package edu.pe.upao.buk.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BenefitRequest {
    private String benefitText;

    public String getBenefitText() {
        return benefitText;
    }

    public void setBenefitText(String benefitText) {
        this.benefitText = benefitText;
    }
}
