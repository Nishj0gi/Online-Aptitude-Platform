
package com.aptivise.aptitude_test.controller;

import com.aptivise.aptitude_test.model.Question;
import com.aptivise.aptitude_test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*") // Allow frontend to access
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // CREATE - Add new question
    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question created = questionService.createQuestion(question);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // READ - Get all questions
    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // READ - Get question by ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getQuestionById(id);
        if (question != null) {
            return new ResponseEntity<>(question, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // READ - Get random questions for test
    @GetMapping("/random")
    public ResponseEntity<List<Question>> getRandomQuestions() {
        List<Question> questions = questionService.getRandomQuestions();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // UPDATE - Update existing question
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id,
                                                   @RequestBody Question question) {
        Question updated = questionService.updateQuestion(id, question);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE - Delete question
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        boolean deleted = questionService.deleteQuestion(id);
        if (deleted) {
            return new ResponseEntity<>("Question deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
    }
}