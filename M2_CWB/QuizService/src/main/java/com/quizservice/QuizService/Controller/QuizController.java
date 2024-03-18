package com.quizservice.QuizService.Controller;

import com.quizservice.QuizService.entity.Quiz;
import com.quizservice.QuizService.services.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    //create
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz ){
       return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> getAllQuiz(){
        return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz getOne(@PathVariable Long id){
        return quizService.get(id);
    }


}
