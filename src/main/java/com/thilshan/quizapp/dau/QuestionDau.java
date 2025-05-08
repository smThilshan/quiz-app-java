package com.thilshan.quizapp.dau;

import com.thilshan.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDau extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

}
