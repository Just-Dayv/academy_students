package com.cwgplc.studentregistration.dto;

import com.cwgplc.studentregistration.entity.FacultyEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class FacultyResponse extends Response{

    private  int facultyId;

    private String facultyName;
    public FacultyResponse (String code, String description, String name, int id){
      super(code, description);
      this.facultyName = name;
        this.facultyId = id;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    @Override
    public String toString(){
        return "Faculty{" +
                "code='" + getCode() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", name='" + getFacultyName() + '\'' +
                ", id='" + getFacultyId() + '\'' +
                '}';
    }


//    public FacultyEntity toFacultyEntity(){
//      return new FacultyEntity(super.getName(),getID());
//  }




}
