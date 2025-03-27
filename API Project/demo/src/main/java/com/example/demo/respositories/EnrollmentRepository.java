package com.example.demo.respositories;

import com.example.demo.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    @Query("SELECT e FROM Enrollment e WHERE e.user.id = :userId")
    List<Enrollment> findByUserId(@Param("userId") Long userId);
}
    
