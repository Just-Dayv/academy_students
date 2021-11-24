package com.cwgplc.studentregistration.controller;

import com.cwgplc.studentregistration.dto.*;
import com.cwgplc.studentregistration.entity.DepartmentEntity;
import com.cwgplc.studentregistration.entity.FacultyEntity;
import com.cwgplc.studentregistration.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/admin/department")
    ResponseEntity<Response> createDepartment (@RequestBody @Validated(CreateEntityRequest.class ) DepartmentRequest departmentRequest) {
      DepartmentEntity departmentEntity = departmentService.createDepartment(departmentRequest);
        return ResponseEntity.ok(new DepartmentResponse("201","Created", departmentEntity));
    }

    @PutMapping("/admin/department")
    ResponseEntity<Response> updateDepartment(@RequestBody @Validated(UpdateEntityRequest.class) DepartmentRequest departmentRequest  ) {

       DepartmentEntity departmentEntity = departmentService.updateDepartment(departmentRequest);
        return  ResponseEntity.ok(new DepartmentResponse("200","Updated",departmentEntity));
    }

    @GetMapping("/admin/department/{id}")
    ResponseEntity<DepartmentEntity> getDepartment(@PathVariable int id) {
        DepartmentEntity departmentEntity = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(departmentEntity);
    }

    @GetMapping("/admin/department")
    ResponseEntity<Iterable<DepartmentEntity>> getAll() {
        Iterable<DepartmentEntity> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}
