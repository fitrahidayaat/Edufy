package com.kelompok7.Service.Impl;

import com.kelompok7.Model.Material;
import com.kelompok7.Repository.MaterialRepository;
import com.kelompok7.Service.MaterialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private MaterialRepository materialRepo;

    public MaterialServiceImpl(MaterialRepository materialRepo) {
        this.materialRepo = materialRepo;
    }

    @Override
    public List<Material> ShowByCourse(String course) {
        List<Material> materi = materialRepo.findByCourse(course);
        return materi ;
    }

    @Override
    public Material saveMaterial(Material material) {
        return materialRepo.save(material);
    }

    @Override
    public Material getMaterialById(Long id) {
        return materialRepo.findById(id).get();
    }

    @Override
    public Material updateMaterial(Material material) {
        return materialRepo.save(material);
    }

    @Override
    public void deleteMaterial(Long id) {
        materialRepo.deleteById(id);
    }
}
