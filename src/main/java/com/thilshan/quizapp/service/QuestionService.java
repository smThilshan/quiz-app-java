package com.thilshan.quizapp.service;
import com.thilshan.quizapp.Question;
import com.thilshan.quizapp.dau.QuestionDau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDau questionDau;

    public ResponseEntity< List<Question> >getAllQuestions() {
        try {
            return new ResponseEntity<>( questionDau.findAll(), HttpStatus.OK);

        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>( questionDau.findByCategory(category), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDau.save(question);
        return new ResponseEntity<>( "success", HttpStatus.CREATED);
    }
}
