package edu.pe.upao.buk.controllers;

import edu.pe.upao.buk.dtos.*;
import edu.pe.upao.buk.models.Announcement;
import edu.pe.upao.buk.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAnnouncement(@RequestBody CreateAnnouncementRequest createAnnouncementRequest) {
        // Aquí deberías implementar la lógica para procesar la solicitud y guardar la información en tu base de datos

        // Devuelve una respuesta de éxito si todo va bien
        return new ResponseEntity<>("Announcement created successfully", HttpStatus.CREATED);
    }
}