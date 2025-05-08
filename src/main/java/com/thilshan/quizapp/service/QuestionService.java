package com.thilshan.quizapp.service;
import com.thilshan.quizapp.Question;
import com.thilshan.quizapp.dau.QuestionDau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDau questionDau;

    public List<Question> getAllQuestions() {
       return questionDau.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDau.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDau.save(question);
        return "success";
    }
}
