package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman
 */
public class School /*implements ISchool*/ {

    private List<Course> courses;
    private List<Teacher> teachers;
    private List<Student> students;

    public School() {
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    // TODO: check if specific timeSlot action is available in course
    public boolean addStudentToCourseAction(Course course, Student student, TimeSlot timeSlot) {

        //check if student is present at school
        if (students.stream().noneMatch(studentAtSchool -> studentAtSchool.equals(student))) {
            return false;
        }

        //check if course is present at school
        if (courses.stream().noneMatch(courseAtSchool -> courseAtSchool.equals(course))) {
            return false;
        }

        //check if course action has a free capacity for new student
        if (!course.getActions().stream()
                .filter((courseAction) -> (courseAction.getTimeSlot()
                .equals(timeSlot)))
                .noneMatch((courseAction) -> (courseAction.getStudents().size() >= courseAction.getCourseCapacity()))) {
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

    public List<Course> getCourses() {
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

}
