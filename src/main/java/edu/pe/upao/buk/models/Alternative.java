package edu.pe.upao.buk.models;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id_fk")
    private Question question;
}
