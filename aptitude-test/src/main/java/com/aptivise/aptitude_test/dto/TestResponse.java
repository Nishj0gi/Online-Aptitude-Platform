package com.aptivise.aptitude_test.dto;

public class TestResponse {

    private Integer score;
    private Integer totalQuestions;
    private Double percentage;
    private String badge;
    private String message;

    // Constructors
    public TestResponse() {
    }

    public TestResponse(Integer score, Integer totalQuestions, Double percentage,
                        String badge, String message) {
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.percentage = percentage;
        this.badge = badge;
        this.message = message;
    }

    // Getters and Setters
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}