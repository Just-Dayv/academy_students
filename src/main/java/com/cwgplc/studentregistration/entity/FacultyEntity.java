package com.cwgplc.studentregistration.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "faculty")
@Data
public class FacultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")

    private String name;

    public String getName(){
        return name;
    }

    public FacultyEntity() {
    }

    public FacultyEntity(String name) {
        this.name = name;
    }

    public FacultyEntity(String name, int id) {
        this(name);
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
