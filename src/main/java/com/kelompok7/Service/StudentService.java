package com.kelompok7.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelompok7.Model.Student;
import com.kelompok7.Repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository sRepo;


    public void saveStudent(Student s){
        sRepo.save(s);
    }

    public List<Student> showStudents(){
        return sRepo.findAll();
    }

}
