/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.Iterator;

/**
 *
 * @author Roman
 */
public interface ISchool {

    // TODO: check if student is present at school
    // TODO: check if course is present at school
    // TODO: check if specific timeSlot action is available in course
    // TODO: check if course action has a free capacity for new student
    boolean addStudentToCourseAction(Course course, Student student, TimeSlot timeSlot);

    void addCourse(Course course);
    
    boolean addCourseAction(Course course, CourseAction courseAction);
    
    void addStudent(Student student);
    
    void addTeacher(Teacher teacher);
    
    // TODO: iterator, iterable, enumerable, or what... But ensure that original collection is not modifiable
    Iterator<Course> getCourses();
    
    // TODO: finish this main controller interface 
    
    
}
