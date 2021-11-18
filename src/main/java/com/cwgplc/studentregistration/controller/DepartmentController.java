package com.cwgplc.studentregistration.controller;

import com.cwgplc.studentregistration.dto.CreateEntityRequest;
import com.cwgplc.studentregistration.dto.DepartmentRequest;
import com.cwgplc.studentregistration.dto.DepartmentResponse;
import com.cwgplc.studentregistration.dto.Response;
import com.cwgplc.studentregistration.entity.DepartmentEntity;
import com.cwgplc.studentregistration.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    ResponseEntity<Response> createDepartment (@RequestBody @Validated(CreateEntityRequest.class ) DepartmentRequest departmentRequest) {
      DepartmentEntity departmentEntity =departmentService.createDepartment(departmentRequest);
        return ResponseEntity.ok(new DepartmentResponse("201","Created", departmentEntity));
    }

    @GetMapping("/department/{id}")
    ResponseEntity<DepartmentEntity> getFaculty(@PathVariable int id) {
        DepartmentEntity departmentEntity = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(departmentEntity);
    }

    @GetMapping("/department")
    ResponseEntity<Iterable<DepartmentEntity>> getAll() {
        Iterable<DepartmentEntity> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}
