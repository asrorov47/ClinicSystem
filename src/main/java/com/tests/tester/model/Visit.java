package com.tests.tester.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name=("patients"))
public class Visit {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer id;

    @ManyToOne
    @JoinColumn(name=("doctor_id"),insertable = false,updatable = false)
    private Doctor doctor;

    @Column(name=("doctor_id"))
    private Integer doctorId;

    @ManyToOne
    @JoinColumn(name =("patient_id"),insertable = false,updatable = false)
    private Patient patient;

    @Column(name =("patient_id"))
    private Integer patientId;


   private String diagnosis;

    private Boolean status;

    @Column(name =("creted_at"))
    private LocalDateTime createdAt;




}
