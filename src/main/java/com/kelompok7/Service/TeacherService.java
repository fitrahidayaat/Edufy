package com.kelompok7.Service;

import com.kelompok7.Model.Student;
import com.kelompok7.Model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacherById(Long id);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacherById(Long id);
}
