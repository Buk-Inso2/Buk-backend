package edu.pe.upao.buk.services;

import edu.pe.upao.buk.dtos.AlternativeRequest;
import edu.pe.upao.buk.dtos.QuestionRequest;
import edu.pe.upao.buk.models.Alternative;
import edu.pe.upao.buk.models.Form;
import edu.pe.upao.buk.models.Question;
import edu.pe.upao.buk.repositories.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AlternativeService alternativeService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, AlternativeService alternativeService) {
        this.questionRepository = questionRepository;
        this.alternativeService = alternativeService;
    }

    @Transactional
    public List<Question> createQuestions(List<QuestionRequest> questionRequests, Form form) {
        List<Question> questions = new ArrayList<>();

        for (QuestionRequest questionRequest : questionRequests) {
            Question question = new Question();
            question.setQuestionText(questionRequest.getQuestionText());
            question.setForm(form); // Establecer la relación con el formulario

            // Crear y asignar alternativas
            List<AlternativeRequest> alternativeRequests = questionRequest.getAlternativeList();
            if (alternativeRequests != null && !alternativeRequests.isEmpty()) {
                List<Alternative> alternatives = alternativeService.createAlternatives(alternativeRequests, question);
                question.setAlternativeList(alternatives);
            }

            questions.add(questionRepository.save(question));
        }

        return questions;
    }

}
