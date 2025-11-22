package com.aptivise.aptitude_test.repository;

import com.aptivise.aptitude_test.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Get random 10 questions
    @Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT 10", nativeQuery = true)
    List<Question> findRandomQuestions();

    // Find by difficulty
    List<Question> findByDifficulty(String difficulty);
}