package com.kelompok7;

import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 

public class Submision {
    private String submisionID;
    private Assigment assigment;
    //private Student student;
    //private file submisionFile;
    private LocalDateTime timestamp;
    private int grade;

    DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = timestamp.format(timeformat);


    public String getSubmisionID() {
        return submisionID;
    }
    public Assigment getAssigment() {
        return assigment;
    }
    // public Student getStudent() {
    //     return student;
    // }
    /*public file getSubmisionFile() {
        return submisionFile;
    }
    public date getTimestamp() {
        return timestamp;
    }
    */
    
}
