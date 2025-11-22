package com.aptivise.aptitude_test.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_results")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer score;

    @Column(nullable = false)
    private Integer totalQuestions;

    @Column(nullable = false)
    private Double percentage;

    @Column(nullable = false)
    private String badge; // Gold, Silver, Bronze, Participant

    @Column(nullable = false)
    private LocalDateTime completedAt;

    // Constructors
    public TestResult() {
        this.completedAt = LocalDateTime.now();
    }

    public TestResult(User user, Integer score, Integer totalQuestions,
                      Double percentage, String badge) {
        this.user = user;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.percentage = percentage;
        this.badge = badge;
        this.completedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}