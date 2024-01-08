package com.kelompok7.Service;

import com.kelompok7.Model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    Course saveCourse(Course course);

    Course getCourseById(Long id);

    Course updateCourse(Course course);

    void deleteCourseById(Long id);


}
