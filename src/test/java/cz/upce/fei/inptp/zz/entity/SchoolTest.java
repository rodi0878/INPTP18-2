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
        School school = new School();
        Student student = new Student();
        
        school.addStudent(student);
        
        assertEquals(student, school.getStudents().get(0));
    }
    
    @Test
    public void testAddCourseAction() {
        Course course = new Course();
        CourseAction courseAction = new CourseAction();
        School school = new School();
        
        school.getCoursesList().add(course);
        school.addCourseAction(course, courseAction);
        
        assertEquals(courseAction, school.getCoursesList().get(0).getActions().get(0));
    }
    
    @Test
    public void testAddTeacher() {
        School school = new School();
        Teacher teacher = new Teacher();
        
        school.addTeacher(teacher);
        assertEquals(teacher, school.getTeachers().get(0));
    }
    
    @Test
    public void testAddCourse() {
        School school = new School();
        Course course = new Course();
        
        school.addCourse(course);
        assertEquals(course, school.getCoursesList().get(0));
    }

    @Test
    public void testAddCourse() {
        Teacher teacher = new Teacher();
        CourseAction courseAction2 = new CourseAction();
        TimeSlot timeSlot2 = new TimeSlot(Day.Saturday, 10, 5);
        Course course2 = new Course();

//        school.getCourses().add(course);
        school.getCourses().add(course2);
        course.getActions().add(courseAction);
        course2.getActions().add(courseAction2);
        school.getStudents().add(student);
        courseAction.getStudents().add(student);
        courseAction2.getStudents().add(student);
        courseAction2.setTimeSlot(timeSlot2);
        school.getTeachers().add(teacher);
        courseAction.setTeacher(teacher);
        courseAction2.setTeacher(teacher);

        school.addCourse(course);

        //assertFalse(result);
    }
    
    @Test(expected = NullPointerException.class)
    public void testAddCourseWhenCourseIsNull() {
        
        school.addCourse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCourseWhenTheCourseIsAlreadyPresentAtSchool() {
        school.getCourses().add(course);

        school.addCourse(course);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCourseWhenStudentIsNotPresentAtSchool() {

        course.getActions().add(courseAction);
        courseAction.getStudents().add(student);
//        school.getStudents().add(student);

        school.addCourse(course);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCourseWhenTeacherHasAnotherActionAtThisTime() {

        Teacher teacher = new Teacher();
        CourseAction courseAction2 = new CourseAction();
        Course course2 = new Course();
        school.getCourses().add(course2);
        course.getActions().add(courseAction);
        course2.getActions().add(courseAction2);
        courseAction2.setTimeSlot(timeSlot);
        school.getTeachers().add(teacher);
        courseAction.setTeacher(teacher);
        courseAction2.setTeacher(teacher);

        school.addCourse(course);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCourseWhenStudentHasAnotherActionAtThisTime() {
        Teacher teacher = new Teacher();
        Teacher teacher2 = new Teacher();
        CourseAction courseAction2 = new CourseAction();        
        Course course2 = new Course();
        school.getCourses().add(course2);
        course.getActions().add(courseAction);
        course2.getActions().add(courseAction2);
        school.getStudents().add(student);
        courseAction.getStudents().add(student);
        courseAction2.getStudents().add(student);
        courseAction2.setTimeSlot(timeSlot);
        school.getTeachers().add(teacher);
        school.getTeachers().add(teacher2);
        courseAction.setTeacher(teacher);
        courseAction2.setTeacher(teacher2);

        school.addCourse(course);
    }

}
