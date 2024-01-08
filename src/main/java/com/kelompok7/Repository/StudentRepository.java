package com.kelompok7.Repository;

import com.kelompok7.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByEmailAndPassword(String email,String password);
}
