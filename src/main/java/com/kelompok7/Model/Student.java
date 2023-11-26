package com.kelompok7.Model;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "Student")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "gradeLevel")
    private String gradeLevel;
    @Column(name = "homeRoomTeacher")
    private String homeRoomTeacher;

    public void viewAssigment(String courseID){
    
    }

    public void submitAssigment(String assigmentID/*, file submision*/){
        
    }
}
