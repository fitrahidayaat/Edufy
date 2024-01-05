package com.kelompok7.Repository;

import com.kelompok7.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
