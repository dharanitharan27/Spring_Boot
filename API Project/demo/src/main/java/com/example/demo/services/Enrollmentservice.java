package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.respositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Enrollmentservice {
    
    @Autowired
    private EnrollmentRepository repository;

    public Enrollment enrollInCourse(Enrollment enrollment) {
        return repository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByUserId() {
        return repository.findAll();
    }

    public Enrollment updateEnrollmentProgress(Long id, Enrollment updatedEnrollment) {
        updatedEnrollment.setId(id);
        return repository.save(updatedEnrollment);
    }

    public String deleteEnrollment(Long id) {
        repository.deleteById(id);

        return "Enrollment deleted successfully";
    }

    public Page<Enrollment> paginated(int page,int size){
        Pageable pageable=PageRequest.of(page,size,Sort.by("progressPercentage").ascending());
        return repository.findAll(pageable);
    }

    public List<Enrollment> getEnrollmentsBy(Long userId) {
        return repository.findByUserId(userId);
    }
}
