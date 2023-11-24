package com.kelompok7.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kelompok7.Model.User;

public interface UserDao extends JpaRepository<User,Integer>{
    
}
