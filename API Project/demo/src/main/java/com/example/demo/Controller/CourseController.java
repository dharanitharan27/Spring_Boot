package com.example.demo.Controller;

import com.example.demo.entities.Course;
import com.example.demo.services.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private Courseservice service;

    @PostMapping
    public Course createOrUpdateCourse(@RequestBody Course course) {
        return service.saveOrUpdateCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return service.getCourseById(id);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        return service.updateCourse(id, updatedCourse);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        return service.deleteCourse(id);
    }

     @GetMapping("/pag")
    public Page<Course>paginated(@RequestParam int page,@RequestParam int size)
    {
        return service.paginated(page,size);
    }
    

    @GetMapping("/difficulty/{level}")
    public List<Course> getCoursesByDifficulty(@PathVariable String level) {
        return service.getCoursesByDifficulty(level);
    }
    @GetMapping("/name")
    public Course getMethodName(@RequestParam String name) {
        return service.getCoursesByName(name);
    }
    
}
