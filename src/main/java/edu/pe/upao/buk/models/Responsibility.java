package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "responsibilities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Responsibility {
    @Id
    @Column(name = "responsibility_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long responsibilityId;
    @Column(name = "responsibility_text")
    private String responsibilityText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id_fk")
    private Job job;
}
