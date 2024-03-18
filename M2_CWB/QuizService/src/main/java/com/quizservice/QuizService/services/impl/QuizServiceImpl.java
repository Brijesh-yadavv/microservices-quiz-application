package com.quizservice.QuizService.services.impl;

import com.quizservice.QuizService.Repository.QuizRepository;
import com.quizservice.QuizService.entity.Quiz;
import com.quizservice.QuizService.services.QuestionClient;
import com.quizservice.QuizService.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {


    private QuizRepository quizRepository;


    //this is used for interacting with the question service running on port 8082
    private QuestionClient questionClient;


    public QuizServiceImpl(QuizRepository quizRepository,QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }




    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes=quizRepository.findAll();
        List<Quiz>newQuizList=quizzes.stream().map(quiz->{
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
                }

        ).collect(Collectors.toList());
        return  newQuizList;
    }

    @Override
    public Quiz get(Long id) {
       Quiz quiz=quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found"));
       quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
       return quiz;
    }

}
