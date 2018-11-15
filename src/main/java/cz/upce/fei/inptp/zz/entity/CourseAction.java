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
public class CourseAction {
    private Course course;
    private TimeSlot timeSlot;
    private Teacher teacher;
    private  List<Student> students;
    private ActionType type;

    public CourseAction() {
        students = new ArrayList<>();                
    }

    public Course getCourse() {
        return course;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public ActionType getType() {
        return type;
    }
    
    
    
}
