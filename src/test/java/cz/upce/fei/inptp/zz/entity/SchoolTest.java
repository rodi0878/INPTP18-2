/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

// TODO: drop all unnecessary comments and @author tags
/**
 *
 * @author Roman
 */
public class SchoolTest {

    @Test
    public void testAddStudentToCourseAction() {
        // TODO: make this initialization smarter...
        // TODO: use of @Before?
        School school = new School();
        Student student = new Student();
        Course course = new Course();
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.day = TimeSlot.Day.Saturdy;
        timeSlot.duration = 2;
        timeSlot.hour = 10;
        
        CourseAction ca = new CourseAction();
        ca.timeSlot = timeSlot;
        
        school.courses.add(course);
        course.actions.add(ca);
        school.students.add(student);
        
        boolean result = school.addStudentToCourseAction(course, student, timeSlot);
        
        assertTrue(result);
        // TODO: do also invalid cases...
    }
    
    @Test
    public void testAddStudentToCourseActionWhenCourseIsNotPresent() {
        School school = new School();
        Student student = new Student();
        Course course = new Course();
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.day = TimeSlot.Day.Saturdy;
        timeSlot.duration = 2;
        timeSlot.hour = 10;
        
        CourseAction ca = new CourseAction();
        ca.timeSlot = timeSlot;
        
        //school.courses.add(course);
        course.actions.add(ca);
        school.students.add(student);
        
        boolean result = school.addStudentToCourseAction(course, student, timeSlot);
        
        //assertFalse(result);
    }
    
    @Test
    public void testAddStudentToCourseActionWhenCourseIsMissingCourseAction() {
        School school = new School();
        Student student = new Student();
        Course course = new Course();
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.day = TimeSlot.Day.Saturdy;
        timeSlot.duration = 2;
        timeSlot.hour = 10;
        
        CourseAction ca = new CourseAction();
        ca.timeSlot = timeSlot;
        
        school.courses.add(course);
        //course.actions.add(ca);
        school.students.add(student);
        
        boolean result = school.addStudentToCourseAction(course, student, timeSlot);
        
        assertFalse(result);
    }
    
    @Test
    public void testAddStudentToCourseActionWhenStudentIsNotInSchool() {
        School school = new School();
        Student student = new Student();
        Course course = new Course();
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.day = TimeSlot.Day.Saturdy;
        timeSlot.duration = 2;
        timeSlot.hour = 10;
        
        CourseAction ca = new CourseAction();
        ca.timeSlot = timeSlot;
        
        school.courses.add(course);
        course.actions.add(ca);
        //school.students.add(student);
        
        boolean result = school.addStudentToCourseAction(course, student, timeSlot);
        
        //assertFalse(result);
    }
}
