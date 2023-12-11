package com.example.student_mangment.controller;

import com.example.student_mangment.entity.Student;
import com.example.student_mangment.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
       this.studentService = studentService;
    }



    @GetMapping("/students")
    public List<Student> listEmployees() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student student = studentService.findById(studentId);

        if (student == null) {
            throw new RuntimeException("Employee id not found - " + studentId);
        }

        return student;
    }



    @PostMapping("/students")
    public void addEmployee(@RequestBody Student student) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        student.setStudentId(0);
        studentService.save(student);

    }

    @PutMapping("/students")
    public void updateEmployee(@RequestBody Student student) {
       studentService.save(student);
    }

    @PostMapping("/students/{studentId}")
    public void delete(@PathVariable("studentId") int theId) {
        Student student= studentService.findById(theId);
        // throw exception if null
        if (student == null) {
            throw new RuntimeException("Student  id not found - " + theId);
        }

        // delete the employee
        studentService.deleteById(theId);

    }
}
