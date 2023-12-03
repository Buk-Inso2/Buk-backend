package edu.pe.upao.buk.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dnis")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reniec {
    @Id
    @Column(name = "dni_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dniId;
    @Column(name = "dni")
    private String dni;
    @Column(name = "first_name")
    private String firstNameDNI;
    @Column(name = "last_name")
    private String lastNameDNI;
}
