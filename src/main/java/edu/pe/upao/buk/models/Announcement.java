package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "announcements")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    @Id
    @Column(name = "announcement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;
    @Column(name = "vacancies")
    private int vacancies;

    @OneToOne(mappedBy = "announcement")
    private Form form;

    @OneToOne(mappedBy = "announcement")
    private Base base;
}
