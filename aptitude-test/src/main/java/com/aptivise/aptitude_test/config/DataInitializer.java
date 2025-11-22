package com.aptivise.aptitude_test.config;

import com.aptivise.aptitude_test.model.Question;
import com.aptivise.aptitude_test.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {
        // Only add sample data if database is empty
        if (questionRepository.count() == 0) {

            // Question 1
            questionRepository.save(new Question(
                    "What is 15 + 27?",
                    "40", "42", "43", "45",
                    2, "Easy"
            ));

            // Question 2
            questionRepository.save(new Question(
                    "If a train travels 120 km in 2 hours, what is its speed?",
                    "50 km/h", "60 km/h", "70 km/h", "80 km/h",
                    2, "Easy"
            ));

            // Question 3
            questionRepository.save(new Question(
                    "What is the square root of 144?",
                    "10", "11", "12", "13",
                    3, "Easy"
            ));

            // Question 4
            questionRepository.save(new Question(
                    "If 5x = 35, what is x?",
                    "5", "6", "7", "8",
                    3, "Medium"
            ));

            // Question 5
            questionRepository.save(new Question(
                    "What is 25% of 200?",
                    "25", "40", "50", "75",
                    3, "Medium"
            ));

            // Question 6
            questionRepository.save(new Question(
                    "A book costs $15 after a 25% discount. What was the original price?",
                    "$18", "$18.75", "$20", "$22.50",
                    3, "Medium"
            ));

            // Question 7
            questionRepository.save(new Question(
                    "If 3^x = 27, what is x?",
                    "2", "3", "4", "9",
                    2, "Medium"
            ));

            // Question 8
            questionRepository.save(new Question(
                    "What is the next number in the sequence: 2, 6, 12, 20, 30, ?",
                    "38", "40", "42", "44",
                    3, "Hard"
            ));

            // Question 9
            questionRepository.save(new Question(
                    "A can complete a work in 10 days and B can do it in 15 days. Working together, how many days will it take?",
                    "5 days", "6 days", "7 days", "8 days",
                    2, "Hard"
            ));

            // Question 10
            questionRepository.save(new Question(
                    "If the ratio of boys to girls is 3:2 and there are 15 boys, how many girls are there?",
                    "8", "9", "10", "12",
                    3, "Medium"
            ));

            System.out.println("✅ Sample questions added to database!");
        }
    }
}


