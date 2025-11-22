
package com.aptivise.aptitude_test.repository;

import com.aptivise.aptitude_test.model.TestResult;
import com.aptivise.aptitude_test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {

    // Get all results for a user, ordered by latest first
    List<TestResult> findByUserOrderByCompletedAtDesc(User user);

    // Get top 10 results for leaderboard
    @Query("SELECT tr FROM TestResult tr ORDER BY tr.score DESC, tr.completedAt ASC")
    List<TestResult> findTop10ByOrderByScoreDescCompletedAtAsc();
}