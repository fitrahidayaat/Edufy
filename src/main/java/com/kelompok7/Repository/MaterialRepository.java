package com.kelompok7.Repository;

import com.kelompok7.Model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material,Long> {
    List<Material> findByCourse(String course);
}
