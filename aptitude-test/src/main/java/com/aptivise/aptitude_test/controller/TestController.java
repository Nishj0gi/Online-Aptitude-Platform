package com.aptivise.aptitude_test.controller;

import com.aptivise.aptitude_test.dto.TestResponse;
import com.aptivise.aptitude_test.dto.TestSubmission;
import com.aptivise.aptitude_test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*")
public class TestController {

    @Autowired
    private TestService testService;

    // Submit test answers
    @PostMapping("/submit")
    public ResponseEntity<TestResponse> submitTest(@RequestBody TestSubmission submission) {
        try {
            TestResponse response = testService.submitTest(submission);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}