package com.example.demo.Controller;

import com.example.demo.entities.LearningGoal;
import com.example.demo.services.LearningGoalservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goals")
public class LearningGoalController {

    @Autowired
    private LearningGoalservice service;

    @PostMapping
    public LearningGoal addGoal(@RequestBody LearningGoal goal) {
        return service.addGoal(goal);
    }

    @GetMapping
    public List<LearningGoal> getAllGoals() {
        return service.getAllGoals();
    }
     
    @GetMapping("/page")
    public Page<LearningGoal>paginated(@RequestParam int page,@RequestParam int size)
    {
        return service.paginated(page,size);
    }

    @PutMapping("/{id}")
    public LearningGoal updateGoal(@PathVariable Long id, @RequestBody LearningGoal updatedGoal) {
        return service.updateGoal(id, updatedGoal);
    }

    @DeleteMapping("/{id}")
    public String deleteGoal(@PathVariable Long id) {
        return service.deleteGoal(id);
    }
    @GetMapping("/before/{date}")
    public List<LearningGoal> getGoalsBeforeDate(@PathVariable Date date) {
        return service.getGoalsBeforeDate(date);
    }

    @GetMapping("/customid/{id}")
    public Optional<LearningGoal> getLanguageByName1(@PathVariable Long id) {
        return service.getLanguageById(id);
    }
}
