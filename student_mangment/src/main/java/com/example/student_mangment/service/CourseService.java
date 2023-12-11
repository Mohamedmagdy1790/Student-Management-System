package com.example.student_mangment.service;


import com.example.student_mangment.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course findById(int theId);

    void save(Course course);

    void deleteById(int theId);
}
