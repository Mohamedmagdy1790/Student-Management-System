package com.example.student_mangment.controller;

import com.example.student_mangment.entity.Teacher;
import com.example.student_mangment.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class TeacherController {

    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> listTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("/teachers/{teacherId}")
    public Teacher getTeacher(@PathVariable int teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        if (teacher == null) {
            throw new RuntimeException("Teacher id not found - " + teacherId);
        }
        return teacher;
    }

    @PostMapping("/teachers")
    public void addTeacher(@RequestBody Teacher teacher) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        teacher.setTeacherId(0);
        teacherService.save(teacher);
    }

    @PutMapping("/teachers")
    public void updateTeacher(@RequestBody Teacher teacher) {
        teacherService.save(teacher);
    }

    @DeleteMapping("/teachers/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") int theId) {
        Teacher teacher = teacherService.findById(theId);
        // throw exception if null
        if (teacher == null) {
            throw new RuntimeException("Teacher id not found - " + theId);
        }

        // delete the teacher
        teacherService.deleteById(theId);
    }
}
