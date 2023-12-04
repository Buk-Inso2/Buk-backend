package edu.pe.upao.buk.dtos;

import edu.pe.upao.buk.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormRequest {
    private List<QuestionRequest> questionList;

}
