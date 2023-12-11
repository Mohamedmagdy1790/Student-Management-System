package com.example.student_mangment.service;

import com.example.student_mangment.Repository.QuizRepository;
import com.example.student_mangment.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }


    @Override
    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public void deleteById(int theId) {
        quizRepository.deleteById(theId);
    }
}