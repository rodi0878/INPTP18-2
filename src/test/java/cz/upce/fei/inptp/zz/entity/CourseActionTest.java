package cz.upce.fei.inptp.zz.entity;

import static org.junit.Assert.*;
import org.junit.Test;

public class CourseActionTest {
    
    @Test
    public void testHasCapacityOnEmptyCourseAction() {
        CourseAction courseAction = new CourseAction();
        courseAction.setCapacity(1);
        
        assertTrue(courseAction.isNotFull());
    }
    
    @Test
    public void testHasCapacityOnZeroCapacityCourseAction() {
        CourseAction courseAction = new CourseAction();
        courseAction.setCapacity(0);
        
        assertFalse(courseAction.isNotFull());
    }
    
    @Test
    public void testHasCapacityOnNotEmptyCourseAction() {
        CourseAction courseAction = new CourseAction();
        courseAction.setCapacity(2);
        courseAction.getStudents().add(new Student());
        
        assertTrue(courseAction.isNotFull());
    }
    
    @Test
    public void testHasCapacityOnFullCourseAction() {
        CourseAction courseAction = new CourseAction();
        courseAction.setCapacity(1);
        courseAction.getStudents().add(new Student());
        
        assertFalse(courseAction.isNotFull());
    }
}
