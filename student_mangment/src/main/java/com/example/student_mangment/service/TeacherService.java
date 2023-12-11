package com.example.student_mangment.service;


import com.example.student_mangment.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher findById(int theId);

    void save(Teacher teacher);

    void deleteById(int theId);
}
