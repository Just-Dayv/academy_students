package com.cwgplc.studentregistration.dto;

import java.util.ArrayList;
import java.util.List;


import org.springframework.validation.FieldError;
import com.cwgplc.studentregistration.dto.Error;

public class ErrorResponse extends  Response{

    private List<Error> errorMessages ;

    public ErrorResponse(String code, String description,  List<Error> errorMessages ) {
        super(code, description);
        this.errorMessages = errorMessages;
    }
    public List<Error> getErrorMessages() {
        return errorMessages;
    }

//    @Override
    public String toString(){
        return super.toString() + errorMessages;
    }
}

