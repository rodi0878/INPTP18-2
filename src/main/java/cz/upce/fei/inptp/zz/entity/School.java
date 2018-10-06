package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roman
 */
// TODO: fix encapsulation on all classes
public class School /*implements ISchool*/ {
    List<Course> courses;
    List<Teacher> teachers;
    List<Student> students;

    public School() {
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }
    
    // TODO: check if student is present at school
    // TODO: check if course is present at school
    // TODO: check if specific timeSlot action is available in course
    // TODO: check if course action has a free capacity for new student
    public boolean addStudentToCourseAction(Course course, Student student, TimeSlot timeSlot) {
        for (CourseAction action : course.actions) {
            if (action.timeSlot.equals(timeSlot)) {
                action.students.add(student);
                student.actions.add(action);
                
                return true;
            }
        }
        
        return false;
    }
    
    
}
