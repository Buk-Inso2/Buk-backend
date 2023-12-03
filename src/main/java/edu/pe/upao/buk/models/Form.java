package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "forms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Form {
    @Id
    @Column(name = "form_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formId;

    @OneToOne
    @JoinColumn(name = "announcement_id_fk")
    private Announcement announcement;

    @OneToMany(mappedBy = "form")
    private List<Question> questions;
}
