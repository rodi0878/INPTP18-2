package cz.upce.fei.inptp.zz.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TeacherTest {
    
    private Teacher teacher;
    
    @Before
    public void initialize() {
        teacher = new Teacher();
    }
    
    @Test
    public void testAddAction() {
        boolean result = teacher.addAction(new CourseAction());
        assertTrue(result);
    }
    
}
