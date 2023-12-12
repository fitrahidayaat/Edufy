package com.kelompok7.Service.Impl;


import com.kelompok7.Model.Admin;
import com.kelompok7.Repository.AdminRepository;
import com.kelompok7.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepo;

    public AdminServiceImpl(AdminRepository adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public List<Admin> getAllAdmin() {
        return adminRepo.findAll();
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepo.findById(id).get();
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public void deleteAdminById(Long id) {
        adminRepo.deleteById(id);
    }


}
