/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.LinkedList;
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

        school.getCoursesList().add(course);
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

        school.getCoursesList().add(course);
        //course.actions.add(courseAction);
        school.getStudents().add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        assertFalse(result);
    }

    @Test
    public void testAddStudentToCourseActionWhenStudentIsNotInSchool() {

        school.getCoursesList().add(course);
        course.getActions().add(courseAction);
        school.getStudents().add(new Student());

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        assertEquals(false, result);
    }
    
    @Test
    public void testAddStudent() {
        Student student = new Student();
        
        boolean isStudentInSchool = school.getStudents().stream()
                .anyMatch((existingStudent) -> existingStudent.equals(student));
        assertEquals(false, isStudentInSchool);
        
        school.addStudent(student);
        isStudentInSchool = school.getStudents().stream()
                .anyMatch((existingStudent) -> existingStudent.equals(student));
        assertEquals(true, isStudentInSchool);
    }
    
    @Test
    public void testAddCourseAction() {
        CourseAction courseAction = new CourseAction();
        Course course = new Course();
        school.getCoursesList().add(course);
        
        boolean isCourseActionInSchoolCourses = school.getCoursesList().stream()
                .filter((c) -> c.equals(course)).findFirst().get().getActions()
                .stream().anyMatch((ca) -> ca.equals(courseAction));
        assertEquals(false, isCourseActionInSchoolCourses);
        
        school.addCourseAction(course, courseAction);
        isCourseActionInSchoolCourses = school.getCoursesList().stream()
                .filter((c) -> c.equals(course)).findFirst().get().getActions()
                .stream().anyMatch((ca) -> ca.equals(courseAction));
        assertEquals(true, isCourseActionInSchoolCourses);
    }
}
