package edu.pe.upao.buk.services;

import edu.pe.upao.buk.dtos.*;
import edu.pe.upao.buk.models.Announcement;
import edu.pe.upao.buk.models.Base;
import edu.pe.upao.buk.models.Form;
import edu.pe.upao.buk.models.Job;
import edu.pe.upao.buk.repositories.AnnouncementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final JobService jobService;
    private final FormService formService;
    private final BaseService baseService;

    @Autowired
    public AnnouncementService(
            AnnouncementRepository announcementRepository,
            JobService jobService,
            FormService formService,
            BaseService baseService
    ) {
        this.announcementRepository = announcementRepository;
        this.jobService = jobService;
        this.formService = formService;
        this.baseService = baseService;
    }

    @Transactional
    public Announcement createAnnouncement(CreateAnnouncementRequest createAnnouncementRequest) {
        try {
            // Lógica de validación y creación del Announcement
            Announcement announcement = new Announcement();
            announcement.setVacancies(createAnnouncementRequest.getAnnouncementRequest().getVacancies());

            // Crear y asignar el Job
            Job job = jobService.createJob(createAnnouncementRequest.getJobRequest(), announcement);
            announcement.setJob(job);

            // Crear y asignar el Form
            Form form = formService.createForm(createAnnouncementRequest.getFormRequest(), announcement);
            announcement.setForm(form);

            // Crear y asignar el Base
            Base base = baseService.createBase(createAnnouncementRequest.getBaseRequest(), announcement);
            announcement.setBase(base);

            // Guardar el Announcement en la base de datos
            return announcementRepository.save(announcement);
        } catch (Exception e) {
            // Manejar la excepción adecuadamente o relanzarla según tus necesidades
            throw new RuntimeException("Error al crear el Announcement", e);
        }
    }
}
