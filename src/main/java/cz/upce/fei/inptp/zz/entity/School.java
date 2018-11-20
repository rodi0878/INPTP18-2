package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Roman
 */
public class School implements ISchool {

    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;

    public School() {
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    // TODO: check if specific timeSlot action is available in course
    // TODO: check if course action has a free capacity for new student
    public boolean addStudentToCourseAction(Course course, Student student, TimeSlot timeSlot) {

        //check if student is present at school
        if (students.stream().noneMatch(studentAtSchool -> studentAtSchool.equals(student))) {
            return false;
        }

        //check if course is present at school
        if (courses.stream().noneMatch(courseAtSchool -> courseAtSchool.equals(course))) {
            return false;
        }

        for (CourseAction action : course.getActions()) {
            if (action.getTimeSlot().equals(timeSlot)) {
                action.getStudents().add(student);
                student.getActions().add(action);

                return true;
            }
        }
        return false;
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
    public void addCourse(Course course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCourseAction(Course course, CourseAction courseAction) {
        return courses.stream().filter((c) -> c.equals(course))
                .findFirst().get().getActions().add(courseAction);
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Course> getCourses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
