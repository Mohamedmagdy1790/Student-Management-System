package com.example.student_mangment.controller;

import com.example.student_mangment.entity.Quiz;
import com.example.student_mangment.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quizzes")
    public List<Quiz> listQuizzes() {
        return quizService.findAll();
    }



    @PostMapping("/quizzes")
    public void addQuiz(@RequestBody Quiz quiz) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        quiz.setQuizId(0);
        quizService.save(quiz);
    }

    @PutMapping("/quizzes")
    public void updateQuiz(@RequestBody Quiz quiz){
        quizService.save(quiz);
    }

}
