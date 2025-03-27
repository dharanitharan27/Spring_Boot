package com.example.demo.respositories;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull; // Import this
import com.example.demo.entities.LearningGoal;

@Repository
public interface LearningGoalRepository extends JpaRepository<LearningGoal, Long> {
    @Query("SELECT lg FROM LearningGoal lg WHERE lg.targetCompletionDate < :targetDate")
    List<LearningGoal> findGoalsBeforeDate(Date targetDate);
    @NonNull
    Optional<LearningGoal> findById(@NonNull Long id); // Add @NonNull here
}
