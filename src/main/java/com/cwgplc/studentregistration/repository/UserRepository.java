package com.cwgplc.studentregistration.repository;

import antlr.actions.python.CodeLexer;
import com.cwgplc.studentregistration.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository <UserEntity, Integer> {
    @Query("SELECT u FROM UserEntity u WHERE u.username = :username" )
    public UserEntity getUserByUsername(@Param("username") String username);
}
