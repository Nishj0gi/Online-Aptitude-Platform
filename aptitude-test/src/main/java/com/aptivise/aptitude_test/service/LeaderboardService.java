package com.aptivise.aptitude_test.service;

import com.aptivise.aptitude_test.model.TestResult;
import com.aptivise.aptitude_test.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private TestResultRepository testResultRepository;

    // Get top 10 results for leaderboard
    public List<TestResult> getTopResults() {
        List<TestResult> allResults = testResultRepository.findTop10ByOrderByScoreDescCompletedAtAsc();
        // Return only top 10
        return allResults.size() > 10 ? allResults.subList(0, 10) : allResults;
    }

    // Get all test results
    public List<TestResult> getAllResults() {
        return testResultRepository.findAll();
    }
}