package com.kelompok7.Service.Impl;

import com.kelompok7.Model.Student;
import com.kelompok7.Model.Teacher;
import com.kelompok7.Repository.TeacherRepository;
import com.kelompok7.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepo;

    public TeacherServiceImpl(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepo.findById(id).get();
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepo.deleteById(id);
    }

    @Override
    public Teacher login(String email, String password) {
        Teacher user = teacherRepo.findByEmailAndPassword(email, password);
        return user;
    }
}
