package com.example.student_mangment.controller;

import com.example.student_mangment.entity.Course;
import com.example.student_mangment.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> listCourses() {
        return courseService.findAll();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable int courseId) {
        Course course = courseService.findById(courseId);
        if (course == null) {
            throw new RuntimeException("Course id not found - " + courseId);
        }
        return course;
    }

    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        course.setCourseId(0);
        courseService.save(course);
    }

    @PutMapping("/courses")
    public void updateCourse(@RequestBody Course course) {
        courseService.save(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") int theId) {
        Course course = courseService.findById(theId);
        // throw exception if null
        if (course == null) {
            throw new RuntimeException("Course id not found - " + theId);
        }

        // delete the course
        courseService.deleteById(theId);
    }
}
