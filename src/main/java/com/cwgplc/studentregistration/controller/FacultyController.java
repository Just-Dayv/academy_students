package com.cwgplc.studentregistration.controller;

import com.cwgplc.studentregistration.dto.*;
import com.cwgplc.studentregistration.entity.FacultyEntity;
import com.cwgplc.studentregistration.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;


@RestController
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(value = "/faculty", method = RequestMethod.POST)
    public ResponseEntity<Response> createFaculty(@RequestBody @Validated(CreateEntityRequest.class) FacultyRequest facultyRequest)  {

        FacultyEntity facultyEntity= facultyService.createFaculty(facultyRequest);
//        System.out.println("Faculty created");
//        System.out.println(facultyResponse.getID());
//        System.out.println(facultyResponse.getName());
//        System.out.println();
        return ResponseEntity.ok(new FacultyResponse(HttpStatus.CREATED.toString(), "Successful", facultyEntity.getName(),facultyEntity.getId()));
    }

    @RequestMapping(value = "/faculty", method = RequestMethod.PUT)
    ResponseEntity<Response> updateFaculty(@RequestBody @Validated(UpdateEntityRequest.class) FacultyRequest facultyRequest ) {

        FacultyEntity facultyEntity = facultyService.updateFaculty(facultyRequest);
        return  ResponseEntity.ok(new FacultyResponse("200","Updated",facultyEntity.getName(),facultyEntity.getId()));
    }

    @RequestMapping(value = "/faculty/{id}", method = RequestMethod.GET)
    ResponseEntity<Response> getFaculty(@PathVariable(name = "id") int fid) {
        FacultyEntity facultyEntity = facultyService.getFacultyById(fid);
        return  ResponseEntity.ok(new FacultyResponse("200","Updated",facultyEntity.getName(),facultyEntity.getId()));

    }

    @RequestMapping(value = "/faculty", method = RequestMethod.GET)
    ResponseEntity<Iterable<FacultyEntity>> getAll() {
        Iterable<FacultyEntity> faculties = facultyService.getAllFalculties();
        return ResponseEntity.ok(faculties);
    }

}
