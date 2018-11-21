/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.Iterator;
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
        timeSlot = new TimeSlot(Day.Saturday, 10, 2);

        courseAction = new CourseAction();
        courseAction.setTimeSlot(timeSlot);
    }

    @Test
    public void testAddStudentToCourseAction() {

        school.addCourse(course);
        course.getActions().add(courseAction);
        school.getStudents().add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        assertTrue(result);
        // TODO: do also invalid cases...
    }

    @Test
    public void testAddStudentToCourseActionWhenCourseIsNotPresent() {

        //school.courses.add(course);
        course.getActions().add(courseAction);
        school.getStudents().add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        //assertFalse(result);
    }

    @Test
    public void testAddStudentToCourseActionWhenCourseIsMissingCourseAction() {

        school.addCourse(course);
        //course.actions.add(courseAction);
        school.getStudents().add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        assertFalse(result);
    }

    @Test
    public void testAddStudentToCourseActionWhenStudentIsNotInSchool() {

        school.addCourse(course);
        course.getActions().add(courseAction);
        //school.students.add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        //assertFalse(result);
    }

    @Test
    public void testEmptySchoolCourses() {
        Iterator<Course> iterator = school.getCourses();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testAddCourseToSchool() {
        school.addCourse(course);
        Iterator<Course> iterator = school.getCourses();

        assertEquals(course, iterator.next());
    }

    @Test(expected = School.DuplicateCoursesException.class)
    public void testAddDuplicityCourseToSchool() {
        school.addCourse(course);
        school.addCourse(course);
    }

    @Test
    public void testAddActionToSchoolCourse() {
        school.addCourse(new Course("C01"));
        boolean result = school.addCourseAction(new Course("C01"), courseAction);
        assertTrue(result);
    }

    @Test
    public void testAddActionToNonExistCourseInSchool() {
        school.addCourse(new Course("C01"));
        boolean result = school.addCourseAction(new Course("02"), courseAction);
        assertFalse(result);
    }
}
