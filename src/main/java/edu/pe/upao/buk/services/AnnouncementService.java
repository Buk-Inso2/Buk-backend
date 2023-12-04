package edu.pe.upao.buk.services;

import edu.pe.upao.buk.dtos.AnnouncementRequest;
import edu.pe.upao.buk.dtos.BaseRequest;
import edu.pe.upao.buk.dtos.FormRequest;
import edu.pe.upao.buk.dtos.JobRequest;
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
    public Announcement createAnnouncement(
            AnnouncementRequest announcementRequest,
            JobRequest jobRequest,
            FormRequest formRequest,
            BaseRequest baseRequest
    ) {
        try {
            // Lógica de validación y creación del Announcement
            Announcement announcement = new Announcement();
            announcement.setVacancies(announcementRequest.getVacancies());

            // Crear y asignar el Job
            Job job = jobService.createJob(jobRequest, announcement);
            announcement.setJob(job);

            // Crear y asignar el Form
            Form form = formService.createForm(formRequest, announcement);
            announcement.setForm(form);

            // Crear y asignar el Base
            Base base = baseService.createBase(baseRequest, announcement);
            announcement.setBase(base);

            // Guardar el Announcement en la base de datos
            return announcementRepository.save(announcement);
        } catch (Exception e) {
            // Manejar la excepción adecuadamente o relanzarla según tus necesidades
            throw new RuntimeException("Error al crear el Announcement", e);
        }
    }
}
