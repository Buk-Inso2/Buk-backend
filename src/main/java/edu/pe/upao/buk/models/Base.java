package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "bases")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Base {
    @Id
    @Column(name = "bases_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basesId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "dead_line")
    private LocalDate deadLine;
    @Column(name = "interview_date")
    private LocalDate interviewDate;
    @Column(name = "candidate_announcement")
    private LocalDate candidateAnnouncement;

    @OneToOne
    @JoinColumn(name = "announcement_id_fk")
    private Announcement announcement;

    @OneToMany(mappedBy = "base")
    private List<Requirement> requirements;

    @OneToMany(mappedBy = "base")
    private List<Evaluator> evaluators;


}
