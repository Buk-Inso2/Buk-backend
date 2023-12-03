package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "requirements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Requirement {
    @Id
    @Column(name = "requirement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requirementId;
    @Column(name = "requirement_text")
    private String requirementText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bases_id_fk")
    private Base base;
}
