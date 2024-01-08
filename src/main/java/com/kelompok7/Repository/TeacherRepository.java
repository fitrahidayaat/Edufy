package com.kelompok7.Repository;

import com.kelompok7.Model.Student;
import com.kelompok7.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByEmailAndPassword(String email, String password);
}
