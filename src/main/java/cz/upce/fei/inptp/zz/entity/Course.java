/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roman
 */
public class Course implements Cloneable{
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
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
