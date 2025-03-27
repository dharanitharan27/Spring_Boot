package com.example.demo.services;

import com.example.demo.entities.Course;
import com.example.demo.respositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Courseservice {
    
    @Autowired
    private CourseRepository repository;

    public Course saveOrUpdateCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course getCourseById(Long id) {
        Optional<Course> course = repository.findById(id);
        return course.orElse(null);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        updatedCourse.setId(id);
        return repository.save(updatedCourse);
    }

    public String deleteCourse(Long id) {
        repository.deleteById(id);
        return "Course deleted successfully";
    }

     public Page<Course> paginated(int page,int size){
        Pageable pageable=PageRequest.of(page,size,Sort.by("name").ascending());
        return repository.findAll(pageable);
    }

    public List<Course> getCoursesByDifficulty(String difficultyLevel) {
        return repository.findByDifficultyLevel(difficultyLevel);
    }

    public Course getCoursesByName(String name) {
        return repository.findByName(name);
    }
}
