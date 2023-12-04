package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

    @OneToOne
    @JoinColumn(name = "announcement_id_fk_job")
    private Announcement announcement;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responsibility> responsibilities;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Benefit> benefits;


}
