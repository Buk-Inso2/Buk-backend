package edu.pe.upao.buk.services;

import edu.pe.upao.buk.dtos.BenefitRequest;
import edu.pe.upao.buk.dtos.JobRequest;
import edu.pe.upao.buk.dtos.ResponsibilityRequest;
import edu.pe.upao.buk.models.*;
import edu.pe.upao.buk.repositories.BenefitRepository;
import edu.pe.upao.buk.repositories.JobRepository;
import edu.pe.upao.buk.repositories.ResponsibilityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final ResponsibilityRepository responsibilityRepository;
    private final BenefitRepository benefitRepository;

    public JobService(JobRepository jobRepository, ResponsibilityRepository responsibilityRepository, BenefitRepository benefitRepository) {
        this.jobRepository = jobRepository;
        this.responsibilityRepository = responsibilityRepository;
        this.benefitRepository = benefitRepository;
    }

    @Transactional
    public Job createJob(JobRequest request, Announcement announcement) {
        // Lógica de validación y creación del Job
        Job job = new Job();
        job.setWorkArea(request.getWorkArea());
        job.setSalary(request.getSalary());
        job.setShift(request.getShift());

        // Asignar la convocatoria al trabajo
        job.setAnnouncement(announcement);
        // Crear y asignar responsabilidades
        List<Responsibility> responsibilities = createResponsibilities(request.getResponsibilities(), job);
        job.setResponsibilities(responsibilities);

        // Crear y asignar beneficios
        List<Benefit> benefits = createBenefits(request.getBenefits(), job);
        job.setBenefits(benefits);

        return jobRepository.save(job);
    }

    private List<Responsibility> createResponsibilities(List<ResponsibilityRequest> responsibilityRequests, Job job) {
        List<Responsibility> responsibilities = new ArrayList<>();
        for (ResponsibilityRequest responsibilityRequest : responsibilityRequests) {
            Responsibility responsibility = new Responsibility();
            responsibility.setResponsibilityText(responsibilityRequest.getResponsibilityText());
            responsibility.setJob(job);
            responsibilities.add(responsibilityRepository.save(responsibility));
        }
        return responsibilities;
    }

    private List<Benefit> createBenefits(List<BenefitRequest> benefitRequests, Job job) {
        List<Benefit> benefits = new ArrayList<>();
        for (BenefitRequest benefitRequest : benefitRequests) {
            Benefit benefit = new Benefit();
            benefit.setBenefitText(benefitRequest.getBenefitText());
            benefit.setJob(job);
            benefits.add(benefitRepository.save(benefit));
        }
        return benefits;
    }
}
