package cz.upce.fei.inptp.zz.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CourseTest {

    private Course course;

    @Before
    public void initialize() {
        course = new Course();
    }

    @Test
    public void testAddAction() {
        boolean result = course.addAction(new CourseAction());
        assertTrue(result);
    }

}
