package com.cwgplc.studentregistration.dto;

import com.cwgplc.studentregistration.entity.Student;

public class StudentResponse extends Response {

    private  Student student;
    public StudentResponse(String code, String description, Student student ) {
        super(code, description);
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}
