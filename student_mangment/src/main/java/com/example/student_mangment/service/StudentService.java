package com.example.student_mangment.service;

import com.example.student_mangment.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    List<Student> findAll();

    Student findById(int theId);

    void save(Student student);

    void deleteById(int theId);
}
