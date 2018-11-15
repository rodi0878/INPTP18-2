package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;

public class School /*implements ISchool*/ {

    List<Course> courses;
    List<Teacher> teachers;
    List<Student> students;

    public School() {
        courses = new ArrayList<>();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
    }

    public boolean checkIsStudentAtSchool(Student student) {
        for (Student st : students) {
            if (st.equals(student)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIsCourseAtSchool(Course course) {
        for (Course course1 : courses) {
            if (course1.equals(course)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkAllStudentsOfCourseArePresentAtSchool(Course newCourse) {
        for (CourseAction courseAction : newCourse.actions) {
            for (Student student : courseAction.getStudents()) {
                if (!checkIsStudentAtSchool(student)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkNoCollisionsWithTeachersAndTimeSlot(Course newCourse) {
        for (Course course : courses) {
            for (CourseAction courseAction : course.actions) {
                for (CourseAction newCourseAction : newCourse.actions) {
                    if (courseAction.getTeacher().equals(newCourseAction.getTeacher())
                            && courseAction.getTimeSlot().equals(newCourseAction.getTimeSlot())) {
                        System.out.println("Collisions with Teacher & TimeSlot");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkNoCollisionsWithStudentsAndTimeSlot(Course newCourse) {
        for (Course course : courses) {
            for (CourseAction courseAction : course.actions) {
                for (CourseAction newCourseAction : newCourse.actions) {
                    for (Student student : courseAction.getStudents()) {
                        for (Student studentOfNewCourseAction : newCourseAction.getStudents()) {
                            if (student.equals(studentOfNewCourseAction)
                                    && courseAction.getTimeSlot().equals(newCourseAction.getTimeSlot())) {
                                System.out.println("Student cannot visit two different courseActions at the same timeSlot");
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public boolean addStudentToCourseAction(Course course, Student student, TimeSlot timeSlot) {
        for (CourseAction action : course.actions) {
            if (action.getTimeSlot().equals(timeSlot)) {
                action.getStudents().add(student);
                student.actions.add(action);

                return true;
            }
        }

        return false;
    }

    public void addCourse(Course newCourse) { 
        if (!checkIsCourseAtSchool(newCourse)) {
            System.out.println("The course is already present at school");
            return;
        }
        if(!checkAllStudentsOfCourseArePresentAtSchool(newCourse)){
            System.out.println("Student is not present at school");
            return;
        }
        if(!checkNoCollisionsWithTeachersAndTimeSlot(newCourse)){
            System.out.println("Teacher has another action at this time");
            return;
        }
        if(!checkNoCollisionsWithStudentsAndTimeSlot(newCourse)){
            System.out.println("Student has another action at this time");
            return;
        }
        courses.add(newCourse);
    }

}
