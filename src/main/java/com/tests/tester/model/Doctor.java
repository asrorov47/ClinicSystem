package com.tests.tester.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name=("doctors"))
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer id;

    private String name;

    private String surname;

    private String direction;

    private String contact;

    private Integer experience;

    private Boolean status;

    @Column(name =("creted_at"))
    private LocalDateTime createdAt;
}
