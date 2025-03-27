package com.example.demo.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
     @Query("SELECT c FROM Course c WHERE c.difficultyLevel = :difficultyLevel")
    List<Course> findByDifficultyLevel(String difficultyLevel);

    Course findByName(String name);
}
