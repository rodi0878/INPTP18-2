package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class School implements ISchool {

    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;
    private static final Logger LOGGER = Logger.getLogger(School.class.getName());

    public School() {
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    @Override
    public boolean addStudentToCourseAction(Course course, Student student, TimeSlot timeSlot) {

      // check if student is present at school
      if (!students.contains(student)) {
          return false;
      }

      // check if course is present at school
      if (!courses.contains(course)) {
          return false;
      }

        //check if specific timeSlot action is available in course
        //check if course action has a free capacity for new student
        for (CourseAction action : course.getActions()) {
            if (action.getTimeSlot().equals(timeSlot)) {
                if (action.isNotFull()) {
                    action.addStudent(student);
                    student.addAction(action);

                    return true;
                }
                break;
            }
        }
        return false;
    }

    @Override
    public void addStudent(Student newStudent) {
        if (newStudent == null) {
            LOGGER.log(Level.INFO, "Tried to add null student object. Throwing an exception.");
            throw new NullPointerException();
      }

      if (!checkIsStudentAtSchool(newStudent)) {
            students.add(newStudent);
            LOGGER.log(Level.INFO, "Student [" + newStudent.getID() + "] was added successfully.");
      }
    }

    public void removeStudent(Student studentToBeRemoved) {
        if (checkIsStudentAtSchool(studentToBeRemoved)) {
            int studentPositionInList = students.indexOf(studentToBeRemoved);
            Student removedStudent = students.remove(studentPositionInList);

            removedStudent.getActions().forEach((ca) -> {
                ca.getStudents().remove(removedStudent);
            });

            removedStudent.getActions().clear();
            LOGGER.log(Level.INFO, "Student was removed from school.");
        }
    }

    public List<Course> getCoursesList() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public void addCourse(Course newCourse) {
        if (newCourse == null) {
            throw new NullPointerException();
        }
        if (checkIsCourseAtSchool(newCourse)) {
            throw new IllegalArgumentException("The course is already present at school");
        }
        if (!checkAllStudentsOfCourseArePresentAtSchool(newCourse)) {
            throw new IllegalArgumentException("Student is not present at school");
        }
        if (!checkNoCollisionsWithTeachersAndTimeSlot(newCourse)) {
            throw new IllegalArgumentException("Teacher has another action at this time");
        }
        if (!checkNoCollisionsWithStudentsAndTimeSlot(newCourse)) {
            throw new IllegalArgumentException("Student has another action at this time");
        }
        courses.add(newCourse);
    }

    @Override
    public boolean addCourseAction(Course course, CourseAction courseAction) {
        return courses.stream().filter((c) -> c.equals(course))
                .findFirst().get().addAction(courseAction);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        if (teacher == null) {
            LOGGER.log(Level.INFO, "Tried to add null teacher object. Throwing an exception.");
            throw new NullPointerException();
        }
        if (teachers.contains(teacher)) {
            throw new IllegalArgumentException("The teacher is already existing");
        }
        teachers.add(teacher);
        LOGGER.log(Level.INFO, "Teacher [" + teacher.getID() + "] was added to school.");
    }

    @Override
    public Iterator<Course> getCourses() {
        List<Course> newList = Collections.unmodifiableList(courses);
        return newList.iterator();
    }

    private boolean checkIsStudentAtSchool(Student student) {
        for (Student studentOfSchool : students) {
            if (studentOfSchool.equals(student)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIsCourseAtSchool(Course course) {
        for (Course courseOfSchool : courses) {
            if (courseOfSchool.equals(course)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAllStudentsOfCourseArePresentAtSchool(Course newCourse) {
        for (CourseAction courseAction : newCourse.getActions()) {
            for (Student student : courseAction.getStudents()) {
                if (!checkIsStudentAtSchool(student)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkNoCollisionsWithTeachersAndTimeSlot(Course newCourse) {
        for (Course course : courses) {
            for (CourseAction courseAction : course.getActions()) {
                for (CourseAction newCourseAction : newCourse.getActions()) {
                    if (courseAction.getTeacher().equals(newCourseAction.getTeacher())
                            && courseAction.getTimeSlot().equals(newCourseAction.getTimeSlot())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkNoCollisionsWithStudentsAndTimeSlot(Course newCourse) {
        for (Course course : courses) {
            for (CourseAction courseAction : course.getActions()) {
                for (CourseAction newCourseAction : newCourse.getActions()) {
                    for (Student student : courseAction.getStudents()) {
                        for (Student studentOfNewCourseAction : newCourseAction.getStudents()) {
                            if (student.equals(studentOfNewCourseAction)
                                    && courseAction.getTimeSlot().equals(newCourseAction.getTimeSlot())) {

                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public void swapCourseActionBetweenTeachers(Teacher orignalTeacher, Teacher newTeacher, CourseAction courseAction) {
        for (CourseAction course : newTeacher.getActions()) {
            if (course.getTimeSlot().isOverlappingWithOtherTimeslot(courseAction.getTimeSlot())) {
                throw new IllegalStateException("New teacher is not available for this Course.");
            }
        }
        newTeacher.getActions().add(courseAction);
        orignalTeacher.getActions().remove(courseAction);
        courseAction.setTeacher(newTeacher);
    }
}
