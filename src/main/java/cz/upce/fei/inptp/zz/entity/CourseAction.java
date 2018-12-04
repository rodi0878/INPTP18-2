package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;

public class CourseAction {

    private Course course;
    private TimeSlot timeSlot;
    private Teacher teacher;
    private List<Student> students;
    private ActionType type;
    private Room room;
    private int capacity;

    public CourseAction() {
        students = new ArrayList<>();
        capacity = Integer.MAX_VALUE;
    }
    
    public boolean isNotFull() {
        return this.students.size() < this.capacity;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        if(room.getRoomCapacity() < capacity)
            throw new IllegalArgumentException("Not enough room capacity for course action");
        this.room = room;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
    public TimeSlot getTimeSlot() {
        return timeSlot;
    }
    
    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
    
    public Teacher getTeacher() {
        return teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public List<Student> getStudents() {
        return students;
    }
    
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public boolean addStudent(Student student) {
        return students.add(student);
    }
    
    public ActionType getType() {
        return type;
    }
    
    public void setType(ActionType type) {
        this.type = type;
    }
   
    
}
