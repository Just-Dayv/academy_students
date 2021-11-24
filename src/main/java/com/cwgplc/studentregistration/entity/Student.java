package com.cwgplc.studentregistration.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;



@Entity
//uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Table(name = "student")
@Data
@Getter @Setter
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

    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name="department_id")
    private DepartmentEntity departmentEntity;

    @OneToOne
    @JoinColumn (name="email", referencedColumnName = "username")
    private UserEntity userEntity;

    public Student (){}

    public Student(String name, String lastName, LocalDate dob, String gender, DepartmentEntity department) {
        this.firstName = name;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        departmentEntity = department;
    }

    public Student(int id, String name, String lastName, LocalDate dob, String gender, DepartmentEntity departmentEntity) {
        this(name, lastName, dob, gender, departmentEntity);
        this.id = id;
    }


}
