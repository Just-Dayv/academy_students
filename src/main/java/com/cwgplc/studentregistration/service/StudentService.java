package com.cwgplc.studentregistration.service;

import com.cwgplc.studentregistration.dto.StudentRequest;
import com.cwgplc.studentregistration.entity.DepartmentEntity;
import com.cwgplc.studentregistration.entity.Student;
import com.cwgplc.studentregistration.entity.UserEntity;
import com.cwgplc.studentregistration.exception.InvalidRequestException;
import com.cwgplc.studentregistration.repository.DepartmentRepository;
import com.cwgplc.studentregistration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Student createStudent(StudentRequest studentRequest ) {
      if (departmentRepository.existsById(studentRequest.getDepartmentID())) {
          DepartmentEntity department = departmentRepository.findById(studentRequest.getDepartmentID()).get();
          return studentRepository.save(new Student(studentRequest.getFirstName(), studentRequest.getLastName(),
                  studentRequest.getDob(), studentRequest.getGender(), department ));
      }
      else throw new InvalidRequestException("No Department Exists For Specified ID");

    }

    public Student updateStudent (StudentRequest studentRequest ) {

        if (studentRepository.existsById(studentRequest.getId()))
        {
            if (departmentRepository.existsById(studentRequest.getDepartmentID())) {
                return studentRepository.save(new Student(studentRequest.getId(),studentRequest.getFirstName(), studentRequest.getLastName(),
                        studentRequest.getDob(), studentRequest.getGender(), departmentRepository.findById(studentRequest.getDepartmentID()).get() ));
            } else
                throw new InvalidRequestException("No Department Exists For Specified ID");
        }
        else throw new InvalidRequestException("No Student Exists For Specified ID");
    }

   public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }

    public Student getStudentByUsername(UserEntity userEntity) {
        System.out.println("In student service "+ studentRepository.findByUserEntity(userEntity).get());
        return studentRepository.findByUserEntity(userEntity).get();
    }


    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}
