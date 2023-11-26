package com.kelompok7.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelompok7.Model.Student;
import com.kelompok7.Repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository sRepo;
    public void save(Student s){
        sRepo.save(s);
    }

}
