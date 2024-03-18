package com.quizservice.QuizService.services;

import com.quizservice.QuizService.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz> get();


    Quiz get(Long id);



}
