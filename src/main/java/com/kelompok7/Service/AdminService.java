package com.kelompok7.Service;

import com.kelompok7.Model.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAllAdmin();

    Admin saveAdmin(Admin admin);

    Admin getAdminById(Long id);

    Admin updateAdmin(Admin admin);

    void deleteAdminById(Long id);
}
