package com.aptivise.aptitude_test.controller;

import com.aptivise.aptitude_test.model.TestResult;
import com.aptivise.aptitude_test.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
@CrossOrigin(origins = "*")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    // Get top 10 results
    @GetMapping
    public ResponseEntity<List<TestResult>> getLeaderboard() {
        List<TestResult> topResults = leaderboardService.getTopResults();
        return new ResponseEntity<>(topResults, HttpStatus.OK);
    }

    // Get all results
    @GetMapping("/all")
    public ResponseEntity<List<TestResult>> getAllResults() {
        List<TestResult> allResults = leaderboardService.getAllResults();
        return new ResponseEntity<>(allResults, HttpStatus.OK);
    }
}