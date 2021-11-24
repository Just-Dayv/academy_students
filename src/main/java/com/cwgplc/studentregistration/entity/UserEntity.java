package com.cwgplc.studentregistration.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//, uniqueConstraints = {@UniqueConstraint(columnNames = "username")}
@Table(name = "users")
public class UserEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String role;

    public UserEntity() {
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

}