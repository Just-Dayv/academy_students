package com.cwgplc.studentregistration.dto;

import lombok.Data;

@Data
public class Response {

    private String code;
    private String description;


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Response(String code, String description) {
        this.code = code;
        this.description = description;
    }

}
