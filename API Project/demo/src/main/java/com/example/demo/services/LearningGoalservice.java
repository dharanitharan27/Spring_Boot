package com.example.demo.services;

import com.example.demo.entities.LearningGoal;
import com.example.demo.respositories.LearningGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LearningGoalservice {

    @Autowired
    private LearningGoalRepository repository;

    public LearningGoal addGoal(LearningGoal goal) {
        return repository.save(goal);
    }

    public List<LearningGoal> getAllGoals() {
        return repository.findAll();
    }

    public LearningGoal updateGoal(Long id, LearningGoal updatedGoal) {
        updatedGoal.setId(id);
        return repository.save(updatedGoal);
    }

    public String deleteGoal(Long id) {
        repository.deleteById(id);
        return "Learning goal deleted successfully";
    }

    public Page<LearningGoal> paginated(int page,int size){
        Pageable pageable=PageRequest.of(page,size,Sort.by("id").ascending());
        return repository.findAll(pageable);
    }

    public List<LearningGoal> getGoalsBeforeDate(Date date) {
        return repository.findGoalsBeforeDate(date);
    }
    public Optional<LearningGoal> getLanguageById(Long id) {
        return repository.findById(id);
    }
}
