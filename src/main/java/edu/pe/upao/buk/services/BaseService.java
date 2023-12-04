package edu.pe.upao.buk.services;

import edu.pe.upao.buk.dtos.BaseRequest;
import edu.pe.upao.buk.dtos.EvaluatorRequest;
import edu.pe.upao.buk.dtos.RequirementRequest;
import edu.pe.upao.buk.models.Announcement;
import edu.pe.upao.buk.models.Base;
import edu.pe.upao.buk.models.Evaluator;
import edu.pe.upao.buk.models.Requirement;
import edu.pe.upao.buk.repositories.BaseRepository;
import edu.pe.upao.buk.repositories.EvaluatorRepository;
import edu.pe.upao.buk.repositories.RequirementRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseService {
    private final BaseRepository baseRepository;
    private final RequirementRepository requirementRepository;
    private final EvaluatorRepository evaluatorRepository;
    public BaseService(BaseRepository baseRepository, RequirementRepository requirementRepository, EvaluatorRepository evaluatorRepository) {
        this.baseRepository = baseRepository;
        this.requirementRepository = requirementRepository;
        this.evaluatorRepository = evaluatorRepository;
    }

    @Transactional
    public Base createBase(BaseRequest request, Announcement announcement) {
        // Lógica de validación y creación del Base
        Base base = new Base();
        base.setStartDate(request.getStartDate());
        base.setDeadLine(request.getDeadLine());
        base.setInterviewDate(request.getInterviewDate());
        base.setCandidateAnnouncement(request.getCandidateAnnouncement());

        // Asignar la convocatoria al Base
        base.setAnnouncement(announcement);

        // Crear y asignar requisitos
        List<Requirement> requirements = createRequirements(request.getRequirements(), base);
        base.setRequirements(requirements);

        // Crear y asignar evaluadores
        List<Evaluator> evaluators = createEvaluators(request.getEvaluators(), base);
        base.setEvaluators(evaluators);

        return baseRepository.save(base);
    }

    private List<Requirement> createRequirements(List<RequirementRequest> requirementRequests, Base base) {
        List<Requirement> requirements = new ArrayList<>();
        for (RequirementRequest requirementRequest : requirementRequests) {
            Requirement requirement = new Requirement();
            requirement.setRequirementText(requirementRequest.getRequirementText());
            requirement.setBase(base);
            requirements.add(requirementRepository.save(requirement));
        }
        return requirements;
    }

    private List<Evaluator> createEvaluators(List<EvaluatorRequest> evaluatorRequests, Base base) {
        List<Evaluator> evaluators = new ArrayList<>();
        for (EvaluatorRequest evaluatorRequest : evaluatorRequests) {
            Evaluator evaluator = new Evaluator();
            evaluator.setEvaluatorName(evaluatorRequest.getEvaluatorName());
            evaluator.setBase(base);
            evaluators.add(evaluatorRepository.save(evaluator));
        }
        return evaluators;
    }
}
