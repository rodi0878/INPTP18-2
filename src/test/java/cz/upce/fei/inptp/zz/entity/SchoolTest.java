/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public void testAddStudentToEmptyCourseAction() {
        Student student = new Student();
        CourseAction courseAction = new CourseAction();
        TimeSlot timeSlot = new TimeSlot(Day.Saturday, 10, 2);
        Course course = new Course();
        School school = new School();
        
        school.addCourse(course);
        course.getActions().add(courseAction);
        courseAction.setTimeSlot(timeSlot);
        school.getStudents().add(student);
        courseAction.setCapacity(1);

        assertTrue(school.addStudentToCourseAction(course, student, timeSlot));
    }
    
    @Test
    public void testAddStudentToZeroCapacityCourseAction() {
        Student student = new Student();
        CourseAction courseAction = new CourseAction();
        TimeSlot timeSlot = new TimeSlot(Day.Saturday, 10, 2);
        Course course = new Course();
        School school = new School();
        
        school.addCourse(course);
        course.getActions().add(courseAction);
        courseAction.setTimeSlot(timeSlot);
        school.getStudents().add(student);
        courseAction.setCapacity(0);

        assertFalse(school.addStudentToCourseAction(course, student, timeSlot));
    }
    
    @Test
    public void testAddStudentToNotEmptyCourseAction() {
        Student student = new Student();
        CourseAction courseAction = new CourseAction();
        TimeSlot timeSlot = new TimeSlot(Day.Saturday, 10, 2);
        Course course = new Course();
        School school = new School();
        
        school.addCourse(course);
        course.getActions().add(courseAction);
        courseAction.setTimeSlot(timeSlot);
        school.getStudents().add(student);
        courseAction.setCapacity(2);

        courseAction.getStudents().add(new Student());
        
        assertTrue(school.addStudentToCourseAction(course, student, timeSlot));
    }
    
    @Test
    public void testAddStudentToFullCourseAction() {
        Student student = new Student();
        CourseAction courseAction = new CourseAction();
        TimeSlot timeSlot = new TimeSlot(Day.Saturday, 10, 2);
        Course course = new Course();
        School school = new School();
        
        school.addCourse(course);
        course.getActions().add(courseAction);
        courseAction.setTimeSlot(timeSlot);
        school.getStudents().add(student);
        courseAction.setCapacity(1);

        courseAction.getStudents().add(new Student());
        
        assertFalse(school.addStudentToCourseAction(course, student, timeSlot));
    }
    
    @Test
    public void testGetCoursesIteratorIsUnmodifiable(){
        school = new School();
        school.addCourse(new Course());
        school.addCourse(new Course());
        school.addCourse(new Course());
        
        List<Course> immutableList = new ArrayList<>();
        List<Course> originalList = school.getCoursesList();
        Iterator it = school.getCourses();
        while (it.hasNext()) {
            Course course = (Course) it.next();
            immutableList.add(course);
        }
        
        boolean addressOfObjIsEqual = false;
        for (int i = 0; i < immutableList.size(); i++) {
            if(immutableList.get(i).equals(originalList.get(i)))
                addressOfObjIsEqual = true;
        }        
        assertFalse(addressOfObjIsEqual);                        
    }
    
    @Test
    public void testGetCoursesIteratorHasNextMethod(){
        school = new School();
        school.addCourse(new Course());
        Iterator it = school.getCourses();
        assertTrue(it.hasNext());
    }
    
    @Test
    public void testGetCoursesIteratorReturnsAllCourses(){
        school = new School();
        school.addCourse(new Course());   
        school.addCourse(new Course());   
        school.addCourse(new Course());   
        school.addCourse(new Course());   
        int numberOfReturn = 0;
        
        Iterator it = school.getCourses();        
        while (it.hasNext()) {
            it.next();
            numberOfReturn++;   
        }
        assertEquals(numberOfReturn, school.getCoursesList().size());
    }
    
}
