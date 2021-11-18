package com.cwgplc.studentregistration.repository;

import com.cwgplc.studentregistration.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}
