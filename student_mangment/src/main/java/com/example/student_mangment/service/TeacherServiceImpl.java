package com.example.student_mangment.service;

import com.example.student_mangment.Repository.TeacherRepository;
import com.example.student_mangment.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{
   private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int theId) {
        Optional<Teacher> result = teacherRepository.findById(theId);

        Teacher teacher = null;

        if (result.isPresent()) {
            teacher = result.get();
        }
        else {
            // we didn't find the student
            throw new RuntimeException("Did not find student id - " + theId);
        }

        return teacher;
    }

    @Override
    public void save(Teacher teacher) {
       teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(int theId) {
       teacherRepository.deleteById(theId);
    }
}
