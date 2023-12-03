package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "evaluators")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evaluator {
    @Id
    @Column(name = "evaluator_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluatorId;
    @Column(name = "evaluator_name")
    private String evaluatorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bases_id_fk_evaluator")
    private Base base;
}
