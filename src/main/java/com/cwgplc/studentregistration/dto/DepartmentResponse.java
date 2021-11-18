package com.cwgplc.studentregistration.dto;

import com.cwgplc.studentregistration.entity.DepartmentEntity;

public class DepartmentResponse extends Response{

    private final DepartmentEntity departmentEntity;

    public DepartmentResponse(String code, String description, DepartmentEntity departmentEntity) {
        super(code, description);
        this.departmentEntity = departmentEntity;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }
}
