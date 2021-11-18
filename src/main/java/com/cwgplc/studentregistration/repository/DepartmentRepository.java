package com.cwgplc.studentregistration.repository;

import com.cwgplc.studentregistration.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity,Integer> {
}
