package com.cwgplc.studentregistration.repository;

import com.cwgplc.studentregistration.entity.Student;
import com.cwgplc.studentregistration.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface StudentRepository extends CrudRepository<Student,Integer> {


    //  @Query("SELECT s FROM Student s  WHERE s.userEntity.username = :email")
//@Query( "select email, id, first_name,last_name,gender, dob, department_id from Student where email = :email")
    Optional<Student> findByUserEntity ( UserEntity userEntity );


}
