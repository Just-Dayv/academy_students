package com.cwgplc.studentregistration.repository;

import com.cwgplc.studentregistration.entity.FacultyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<FacultyEntity, Integer> {
}
