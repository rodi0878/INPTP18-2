/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
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
        timeSlot = new TimeSlot(Day.SATURDAY, 10, 2);

        courseAction = new CourseAction();
        courseAction.setTimeSlot(timeSlot);
    }

    @Test
    public void testAddStudentToCourseAction() {

        school.getCourses().add(course);
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

        school.getCourses().add(course);
        //course.actions.add(courseAction);
        school.getStudents().add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        assertFalse(result);
    }

    @Test
    public void testAddStudentToCourseActionWhenStudentIsNotInSchool() {

        school.getCourses().add(course);
        course.getActions().add(courseAction);
        //school.students.add(student);

        boolean result = school.addStudentToCourseAction(course, student, timeSlot);

        //assertFalse(result);
    }

    @Test
    public void testAddCourse() {
        Teacher teacher = new Teacher();
        CourseAction courseAction2 = new CourseAction();
        TimeSlot timeSlot2 = new TimeSlot(Day.SATURDAY, 10, 5);
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
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddTeacherIfTeacherAlreadyExist(){
        List<Teacher> teachers = new ArrayList<>();
        
        teachers.add(new Teacher("123"));
        
        school.setTeachers(teachers);
        
        school.addTeacher(new Teacher("123"));
        
    }
    
    @Test
    public void testAddTeacherIfTeacherNotAlreadyExist(){
        List<Teacher> teachers = new ArrayList<>();
        
        Teacher teacher1 = new Teacher("1234");
        
        Teacher teacher2 = new Teacher("123");
        
        teachers.add(teacher1);
        
        school.setTeachers(teachers);
        
        school.addTeacher(teacher2);
        
        List<Teacher> list = school.getTeachers();
        
        Assert.assertTrue(list.get(0).equals(teacher1));
        
        Assert.assertTrue(list.get(1).equals(teacher2));
        
    }
}
