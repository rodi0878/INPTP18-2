/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// TODO: drop all unnecessary comments and @author tags
/**
 *
 * @author Roman
 */
public class SchoolTest {

    private School school;
    private Student student;
    private Course course;
    private TimeSlot timeSlot;
    private CourseAction courseAction;

    @Before
    public void initialize() {
        school = new School();
        student = new Student();
        course = new Course();
        timeSlot = new TimeSlot();

        timeSlot.day = TimeSlot.Day.Saturdy;
        timeSlot.duration = 2;
        timeSlot.hour = 10;

        courseAction = new CourseAction();
        courseAction.timeSlot = timeSlot;
    }

    @Test
    public void testAddStudentToCourseAction() {

        school.courses.add(course);
        course.actions.add(courseAction);
        school.students.add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        assertTrue(result);
    }

    @Test
    public void testAddStudentToCourseActionWhenCourseIsNotPresent() {

        course.actions.add(courseAction);
        school.students.add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        assertFalse(result);
    }

    @Test
    public void testAddStudentToCourseActionWhenCourseIsMissingCourseAction() {

        school.courses.add(course);
        //course.actions.add(courseAction);
        school.students.add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        assertFalse(result);
    }

    @Test
    public void testAddStudentToCourseActionWhenStudentIsNotInSchool() {

        school.courses.add(course);
        course.actions.add(courseAction);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        assertFalse(result);
    }
}
