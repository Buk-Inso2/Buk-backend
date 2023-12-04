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

    public Long getAlternativeId() {
        return alternativeId;
    }

    public void setAlternativeId(Long alternativeId) {
        this.alternativeId = alternativeId;
    }

    public String getAlternativeText() {
        return alternativeText;
    }

    public void setAlternativeText(String alternativeText) {
        this.alternativeText = alternativeText;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Alternative(String alternativeText, int points) {
        this.alternativeText = alternativeText;
        this.points = points;
    }
}
