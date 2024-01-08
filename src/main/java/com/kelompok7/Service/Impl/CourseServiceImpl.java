package com.kelompok7.Service.Impl;


import com.kelompok7.Model.Course;
import com.kelompok7.Repository.CourseRepository;
import com.kelompok7.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepo;

    public CourseServiceImpl(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> getAllCourse() {
        return  courseRepo.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepo.findById(id).get();
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepo.deleteById(id);
    }
}
