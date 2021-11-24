package com.cwgplc.studentregistration.controller;

import com.cwgplc.studentregistration.dto.*;
import com.cwgplc.studentregistration.entity.DepartmentEntity;
import com.cwgplc.studentregistration.entity.Student;
import com.cwgplc.studentregistration.entity.UserEntity;
import com.cwgplc.studentregistration.service.StudentService;
import com.cwgplc.studentregistration.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;



    @Autowired
    private UserDetailsServiceImpl userDetailsService;

//    @RequestMapping(value = "/student", method = RequestMethod.POST)
//    ResponseEntity<Response> createStudent(@RequestBody  @Validated(CreateEntityRequest.class) StudentRequest studentRequest) {
//        return ResponseEntity.ok(new StudentResponse("201","Created",    studentService.createStudent(studentRequest) ));
//    }
//
//    @PutMapping("/student")
//    ResponseEntity<Response> updateStudent (@RequestBody @Validated(UpdateEntityRequest.class) StudentRequest studentRequest  ) {
//
//        return ResponseEntity.ok(new StudentResponse("201","Updated", studentService.updateStudent(studentRequest) ));
//    }
//
//    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
//    ResponseEntity<Student> getStudent(@PathVariable int id) {
//      Student student= studentService.getStudentById(id);
//        return ResponseEntity.ok(student);
//    }

    @RequestMapping(value = "/student/login", method = RequestMethod.GET)
    ResponseEntity<Student> getLoginResponse(HttpServletRequest httpServletRequest) {
        UserEntity userEntity = userDetailsService.getUserByUserName(httpServletRequest.getUserPrincipal().getName());
        System.out.println(userEntity.getUsername());

        Student student= studentService.getStudentByUsername(userEntity);
        return ResponseEntity.ok(student);
    }

//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    ResponseEntity<Iterable<Student>> getAll() {
//        Iterable<Student> students = studentService.getAllStudents();
//        return ResponseEntity.ok(students);
//    }
}
