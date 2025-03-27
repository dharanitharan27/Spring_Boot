package com.example.demo.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class LearningGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goalName;
    private Date targetCompletionDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public LearningGoal() {}

    public LearningGoal(Long id, String goalName, Date targetCompletionDate) {
        this.id = id;
        this.goalName = goalName;
        this.targetCompletionDate = targetCompletionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Date getTargetCompletionDate() {
        return targetCompletionDate;
    }

    public void setTargetCompletionDate(Date targetCompletionDate) {
        this.targetCompletionDate = targetCompletionDate;
    }
}
