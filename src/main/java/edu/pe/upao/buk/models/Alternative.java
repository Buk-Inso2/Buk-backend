package edu.pe.upao.buk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alternatives")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alternative {
    @Id
    @Column(name = "alternative_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long alternativeId;
    @Column(name = "alternative_text")
    private String alternativeText;
    @Column(name = "points")
    private int points;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id_fk")
    @JsonIgnoreProperties("alternativeList")  // Ignora la propiedad 'alternativeList' al serializar
    private Question question;
}
