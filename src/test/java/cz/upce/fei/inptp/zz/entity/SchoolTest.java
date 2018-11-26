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
        courseAction.setCourseCapacity(3);
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

        boolean result = school.addStudentToCourseAction(course, new Student(), timeSlot);

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
    public void testComparePersonsByIDIsTrue(){
        student.setID("S0001");
        Student student2 = new Student();
        student2.setID("S0001");
        
        assertTrue(student.equals(student2));
    }
    
    @Test
    public void testComparePersonsByIDIsFalse(){
        student.setID("S0001");
        Student student2 = new Student();
        student2.setID("S0002");
        
        assertFalse(student.equals(student2));
    }
    
    @Test
    public void testNewStudentWasAdded(){
        school.addStudent(student);
        
        assertEquals(1, school.getStudents().size());
    }
    
    @Test
    public void testNewStudentWasNotAddedBecauseHeIsAlreadyPresent(){
        student.setID("S0001");
        school.addStudent(student);
       
        Student newStudent = new Student();
        newStudent.setID("S0001");
        school.addStudent(newStudent);
        
        assertEquals(1, school.getStudents().size());
    }
    
    @Test
    public void testStudentWasRemoved(){
        student.setID("S0001");
        school.addStudent(student);
        
        Student studentToBeRemoved = new Student();
        studentToBeRemoved.setID("S0001");
        school.removeStudent(studentToBeRemoved);
        
        assertEquals(0, school.getStudents().size());
    }
    
    @Test
    public void testStudentWasNotRemovedBecauseOfWrongID(){
        student.setID("S0001");
        school.addStudent(student);
        
        Student studentToBeRemoved = new Student();
        studentToBeRemoved.setID("S0002");
        school.removeStudent(studentToBeRemoved);
        
        assertEquals(1, school.getStudents().size());
    }
    
    @Test
    public void testStudentDoesNotHaveCourseActionsAfterHeWasRemoved(){
        student.getActions().add(courseAction);
        student.setID("S0001");
        school.addStudent(student);
        
        Student studentToBeRemoved = new Student();
        studentToBeRemoved.setID("S0001");
        school.removeStudent(studentToBeRemoved);
        
        assertEquals(0, student.getActions().size());
    }
    
    @Test
    public void testRemovedStudentWasRemovedFromHisCourseAction(){
        student.setID("S0001");
        student.getActions().add(courseAction);
        courseAction.getStudents().add(student);
        school.addStudent(student);
        
        school.removeStudent(student);
       
        assertEquals(0, courseAction.getStudents().size());
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
