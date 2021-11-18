package com.cwgplc.studentregistration.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "department")
@Data
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="faculty_id", nullable=false)
    private FacultyEntity facultyEntity;

    public DepartmentEntity() {
    }

    public DepartmentEntity(String name, FacultyEntity facultyEntity) {
        this.name = name;
        this.facultyEntity = facultyEntity;
    }


}
