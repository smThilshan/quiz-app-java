package com.thilshan.quizapp.controller;
import com.thilshan.quizapp.model.Question;
import com.thilshan.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

//    Getting All Questions
    @GetMapping("allQuestions")
    public ResponseEntity< List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    //    Getting Category Wise
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

//    Adding new question
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }
}
