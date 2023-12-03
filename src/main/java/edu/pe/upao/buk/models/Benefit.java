package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "benefits")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Benefit {
    @Id
    @Column(name = "benefit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long benefitId;
    @Column(name = "benefit_text")
    private String benefitText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id_fk_benefit")
    private Job job;
}
