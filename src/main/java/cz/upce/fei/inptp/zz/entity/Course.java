/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Roman
 */
public class Course {

    private String title;
    private String description;
    private List<CourseAction> actions;

    public Course() {
        actions = new ArrayList<>();
    }

    public Course(String title) {
        this.title = title;
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
        if (actions.contains(action)) {
            return false;
        }
        actions.add(action);
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
}
