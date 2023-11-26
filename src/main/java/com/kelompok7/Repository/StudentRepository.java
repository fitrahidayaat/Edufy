package com.kelompok7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelompok7.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
