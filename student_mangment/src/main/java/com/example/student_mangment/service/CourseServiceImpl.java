package com.example.student_mangment.service;


import com.example.student_mangment.Repository.CourseRepository;
import com.example.student_mangment.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }
    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int theId) {
        Optional<Course> result = courseRepository.findById(theId);

        Course course = null;

        if (result.isPresent()) {
            course = result.get();
        }
        else {
            // we didn't find the student
            throw new RuntimeException("Did not find student id - " + theId);
        }

        return course;
    }

    @Override
    public void save(Course course) {
      courseRepository.save(course);
    }

    @Override
    public void deleteById(int theId) {
        courseRepository.deleteById(theId);
    }
}
