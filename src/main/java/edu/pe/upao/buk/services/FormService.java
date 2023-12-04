package edu.pe.upao.buk.services;

import edu.pe.upao.buk.dtos.FormRequest;
import edu.pe.upao.buk.dtos.QuestionRequest;
import edu.pe.upao.buk.models.*;
import edu.pe.upao.buk.repositories.FormRepository;
import edu.pe.upao.buk.repositories.QuestionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormService {
    private final FormRepository formRepository;
    private final QuestionService questionService;

    @Autowired
    public FormService(FormRepository formRepository, QuestionService questionService) {
        this.formRepository = formRepository;
        this.questionService = questionService;
    }

    @Transactional
    public Form createForm(FormRequest request, Announcement announcement) {
        // Lógica de validación y creación del Form
        Form form = new Form();
        // Configurar otros campos usando los datos de FormRequest
        // Asignar la convocatoria al Form
        form.setAnnouncement(announcement);

        // Crear y asignar preguntas con alternativas
        List<QuestionRequest> questionRequests = request.getQuestionList();
        if (questionRequests != null && !questionRequests.isEmpty()) {
            List<Question> questions = questionService.createQuestions(questionRequests, form);
            form.setQuestions(questions);
        }

        // Guardar el Form en la base de datos
        return formRepository.save(form);
    }
}
