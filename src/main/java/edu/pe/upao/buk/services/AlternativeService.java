package edu.pe.upao.buk.services;

import edu.pe.upao.buk.dtos.AlternativeRequest;
import edu.pe.upao.buk.models.Alternative;
import edu.pe.upao.buk.models.Question;
import edu.pe.upao.buk.repositories.AlternativeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlternativeService {

    private final AlternativeRepository alternativeRepository;

    @Autowired
    public AlternativeService(AlternativeRepository alternativeRepository) {
        this.alternativeRepository = alternativeRepository;
    }

    @Transactional
    public List<Alternative> createAlternatives(List<AlternativeRequest> alternativeRequests, Question question) {
        List<Alternative> alternatives = new ArrayList<>();

        for (AlternativeRequest alternativeRequest : alternativeRequests) {
            Alternative alternative = new Alternative();
            alternative.setAlternativeText(alternativeRequest.getAlternativeText());
            alternative.setPoints(alternativeRequest.getPoints());
            alternative.setQuestion(question); // Establecer la relación con la pregunta

            alternatives.add(alternativeRepository.save(alternative));
        }

        return alternatives;
    }

}
