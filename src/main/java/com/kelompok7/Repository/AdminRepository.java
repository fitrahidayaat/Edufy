package com.kelompok7.Repository;

import com.kelompok7.Model.Admin;
import com.kelompok7.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmailAndPassword(String email, String password);
}
