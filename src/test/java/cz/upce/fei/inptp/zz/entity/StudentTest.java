package cz.upce.fei.inptp.zz.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    private Student student;

    @Before
    public void initialize() {
        student = new Student();
    }

    @Test
    public void testAddAction() {
        boolean result = student.addAction(new CourseAction());
        assertTrue(result);
    }

}
