package com.example.demo.Controller;

import com.example.demo.entities.Enrollment;
import com.example.demo.services.Enrollmentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private Enrollmentservice service;

    @PostMapping
    public Enrollment enrollInCourse(@RequestBody Enrollment enrollment) {
        return service.enrollInCourse(enrollment);
    }
    @GetMapping("/user1")
    public List<Enrollment> getEnrollmentsByUserId() {
        return service.getEnrollmentsByUserId();
    }

    @PutMapping("/{id}")
    public Enrollment updateEnrollmentProgress(@PathVariable Long id, @RequestBody Enrollment updatedEnrollment) {
        return service.updateEnrollmentProgress(id, updatedEnrollment);
    }

    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        return service.deleteEnrollment(id);
    }

     @GetMapping("/pag")
    public Page<Enrollment>paginated(@RequestParam int page,@RequestParam int size)
    {
        return service.paginated(page,size);
    }
    
    @GetMapping("/user/{userId}")
    public List<Enrollment> getEnrollmentsBy(@PathVariable Long userId) {
        return service.getEnrollmentsBy(userId);
    }
}
