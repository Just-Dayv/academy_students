package com.cwgplc.studentregistration.service;

import com.cwgplc.studentregistration.dto.DepartmentRequest;
import com.cwgplc.studentregistration.entity.DepartmentEntity;
import com.cwgplc.studentregistration.exception.InvalidRequestException;
import com.cwgplc.studentregistration.repository.DepartmentRepository;
import com.cwgplc.studentregistration.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

   public DepartmentEntity createDepartment(DepartmentRequest departmentRequest ) {

       if(facultyRepository.existsById(departmentRequest.getId())){
          return departmentRepository.save(new DepartmentEntity(departmentRequest.getName(),facultyRepository.findById(departmentRequest.getFacultyID()).get()));
       }
       else
           throw new InvalidRequestException("No Faculty Exists For Specified ID");

    }

   public DepartmentEntity getDepartmentById(int id){
       if(facultyRepository.existsById(id)){
           return departmentRepository.findById(id).get();       }
       else
           throw new InvalidRequestException("No Faculty Exists For Specified ID");

    }

    public Iterable<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
