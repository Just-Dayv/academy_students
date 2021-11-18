package com.cwgplc.studentregistration.service;

import com.cwgplc.studentregistration.entity.Student;
import com.cwgplc.studentregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void createStudent(Student student ) {
        studentRepository .save(student);
    }

   public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
