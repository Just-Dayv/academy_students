package com.cwgplc.studentregistration.service;

import com.cwgplc.studentregistration.dto.FacultyRequest;
import com.cwgplc.studentregistration.dto.FacultyResponse;
import com.cwgplc.studentregistration.entity.FacultyEntity;
import com.cwgplc.studentregistration.exception.InvalidRequestException;
import com.cwgplc.studentregistration.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public FacultyEntity createFaculty(FacultyRequest facultyRequest) {

        return facultyRepository.save(facultyRequest.toFacultyEntity());
    }

    public FacultyEntity updateFaculty(FacultyRequest facultyRequest) {
        if(facultyRepository.existsById(facultyRequest.getId())){
            return facultyRepository.save(facultyRequest.toFacultyEntity());
        }
        else
            throw new InvalidRequestException("No Faculty Exists For Specified ID");
    }

    public FacultyEntity getFacultyById(int id){
        if(facultyRepository.existsById(id)){
            return facultyRepository.findById(id).get();
        }
        else
            throw new InvalidRequestException("No Faculty Exists For Specified ID");

    }

    public Iterable<FacultyEntity> getAllFaculties() {
        return facultyRepository.findAll();
    }
}
