package com.quizservice.QuizService.Repository;

import com.quizservice.QuizService.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
