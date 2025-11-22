
package com.aptivise.aptitude_test.service;

import com.aptivise.aptitude_test.dto.TestResponse;
import com.aptivise.aptitude_test.dto.TestSubmission;
import com.aptivise.aptitude_test.model.Question;
import com.aptivise.aptitude_test.model.TestResult;
import com.aptivise.aptitude_test.model.User;
import com.aptivise.aptitude_test.repository.QuestionRepository;
import com.aptivise.aptitude_test.repository.TestResultRepository;
import com.aptivise.aptitude_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestResultRepository testResultRepository;

    // Submit test and calculate score
    public TestResponse submitTest(TestSubmission submission) {
        // Get user
        User user = userRepository.findById(submission.getUserId()).orElse(null);
        if (user == null) {
            return new TestResponse(0, 0, 0.0, "None", "User not found");
        }

        // Calculate score
        int score = 0;
        int totalQuestions = submission.getAnswers().size();

        for (Map.Entry<Long, Integer> entry : submission.getAnswers().entrySet()) {
            Long questionId = entry.getKey();
            Integer userAnswer = entry.getValue();

            Question question = questionRepository.findById(questionId).orElse(null);
            if (question != null && question.getCorrectOption().equals(userAnswer)) {
                score++;
            }
        }

        // Calculate percentage
        double percentage = (totalQuestions > 0) ? ((double) score / totalQuestions) * 100 : 0.0;

        // Assign badge based on percentage
        String badge = assignBadge(percentage);

        // Save result to database
        TestResult result = new TestResult(user, score, totalQuestions, percentage, badge);
        testResultRepository.save(result);

        // Create response
        String message = generateMessage(percentage);
        return new TestResponse(score, totalQuestions, percentage, badge, message);
    }

    // Assign badge based on percentage
    private String assignBadge(double percentage) {
        if (percentage >= 90) {
            return "Gold";
        } else if (percentage >= 70) {
            return "Silver";
        } else if (percentage >= 50) {
            return "Bronze";
        } else {
            return "Participant";
        }
    }

    // Generate congratulatory message
    private String generateMessage(double percentage) {
        if (percentage >= 90) {
            return "Outstanding! You've earned a Gold badge!";
        } else if (percentage >= 70) {
            return "Great job! You've earned a Silver badge!";
        } else if (percentage >= 50) {
            return "Good effort! You've earned a Bronze badge!";
        } else {
            return "Keep practicing! You've earned a Participant badge!";
        }
    }
}
