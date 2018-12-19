package cz.upce.fei.inptp.zz.entity;

import java.util.Iterator;

public interface ISchool {

  boolean addStudentToCourseAction(Course course, Student student, TimeSlot timeSlot);

  void addCourse(Course course);

  boolean addCourseAction(Course course, CourseAction courseAction);

  void addStudent(Student student);

  void addTeacher(Teacher teacher);

  Iterator<Course> getCourses();

  // TODO: finish this main controller interface


}
