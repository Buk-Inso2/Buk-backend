package edu.pe.upao.buk.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    private String questionText;
    private List<AlternativeRequest> alternativeList;

    // Otros campos y getters/setters

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<AlternativeRequest> getAlternativeList() {
        return alternativeList;
    }

    public void setAlternativeList(List<AlternativeRequest> alternativeList) {
        this.alternativeList = alternativeList;
    }
}
