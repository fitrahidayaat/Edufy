package com.kelompok7.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EdufyUtils {
    
    private EdufyUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
      
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus); 
    
    }
}
