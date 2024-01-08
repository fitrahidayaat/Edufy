package com.kelompok7.Service.Impl;

import com.kelompok7.Model.Student;
import com.kelompok7.Repository.StudentRepository;
import com.kelompok7.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudent() {

        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }

    public Student login(String email, String password) {
        Student user = studentRepo.findByEmailAndPassword(email, password);
        return user;
    }

}
