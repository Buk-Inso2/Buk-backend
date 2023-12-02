package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dni")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DNI {
    @Id
    @Column(name = "dni_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dniId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
