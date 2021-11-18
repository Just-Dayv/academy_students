package com.cwgplc.studentregistration.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name="department_id")
    private DepartmentEntity departmentEntity;

    @Column(name = "gender")
    private String gender;
}
