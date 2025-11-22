
package com.aptivise.aptitude_test.dto;

import java.util.Map;

public class TestSubmission {

    private Long userId;
    private Map<Long, Integer> answers; // questionId -> selectedOption (1-4)

    // Constructors
    public TestSubmission() {
    }

    public TestSubmission(Long userId, Map<Long, Integer> answers) {
        this.userId = userId;
        this.answers = answers;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<Long, Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, Integer> answers) {
        this.answers = answers;
    }
}