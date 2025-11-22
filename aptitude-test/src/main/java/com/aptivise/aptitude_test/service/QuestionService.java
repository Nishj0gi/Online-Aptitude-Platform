package com.aptivise.aptitude_test.service;

import com.aptivise.aptitude_test.model.Question;
import com.aptivise.aptitude_test.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    // Create a new question (CREATE)
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    // Get all questions (READ)
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Get question by ID (READ)
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    // Get random 10 questions for test
    public List<Question> getRandomQuestions() {
        return questionRepository.findRandomQuestions();
    }

    // Update question (UPDATE)
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Question existing = questionRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setQuestionText(updatedQuestion.getQuestionText());
            existing.setOption1(updatedQuestion.getOption1());
            existing.setOption2(updatedQuestion.getOption2());
            existing.setOption3(updatedQuestion.getOption3());
            existing.setOption4(updatedQuestion.getOption4());
            existing.setCorrectOption(updatedQuestion.getCorrectOption());
            existing.setDifficulty(updatedQuestion.getDifficulty());
            return questionRepository.save(existing);
        }
        return null;
    }

    // Delete question (DELETE)
    public boolean deleteQuestion(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}