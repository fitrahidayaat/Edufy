package com.kelompok7.Service;

import com.kelompok7.Model.Material;
import com.kelompok7.Model.Student;

import java.util.List;

public interface MaterialService {
    List<Material> ShowByCourse(String course);

    Material saveMaterial(Material material);

    Material getMaterialById(Long id);

    Material updateMaterial(Material material);

    void deleteMaterial(Long id);

}
