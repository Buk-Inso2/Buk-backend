package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    @Column(name = "work_area")
    private String workArea;
    @Column(name = "salary")
    private int salary;
    @Column(name = "work_shift")
    private String shift;

    @OneToMany(mappedBy = "job")
    private List<Responsibility> responsibilities;

    @OneToMany(mappedBy = "job")
    private List<Benefit> benefits;
}
