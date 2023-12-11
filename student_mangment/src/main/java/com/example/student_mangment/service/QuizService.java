package com.example.student_mangment.service;


import com.example.student_mangment.entity.Quiz;

import java.util.List;

public interface QuizService {

    List<Quiz> findAll();

    void save(Quiz quiz);

    void deleteById(int theId);
}
