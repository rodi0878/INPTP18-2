package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    
    private String title;
    private String description;
    private List<CourseAction> actions;
    
    public Course() {
        actions = new ArrayList<>();
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<CourseAction> getActions() {
        return actions;
    }
    
    public void setActions(List<CourseAction> actions) {
        this.actions = actions;
    }
    
    public boolean addAction(CourseAction action) {
        return actions.add(action);

    }
    
}
