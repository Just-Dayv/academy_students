package com.cwgplc.studentregistration.controller;

import com.cwgplc.studentregistration.entity.Student;
import com.cwgplc.studentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    ResponseEntity<Student> createStudent(@RequestBody  Student student ) {
        studentService.createStudent(student);
        return ResponseEntity.ok(student);
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    ResponseEntity<Student> getFaculty(@PathVariable int id) {
      Student student= studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

 //   @RequestMapping(value = "/student", method = RequestMethod.GET)
//    ResponseEntity<Iterable<Student>> getAll() {
//        Iterable<Student> students = studentService.getAllStudents();
//        return ResponseEntity.ok(students);
//    }
}
