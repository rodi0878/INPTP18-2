/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.Iterator;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author user
 */
public class CourseIteratorTest {

    private School school;
    private Course course;

    @Before
    public void initialize() {
        school = new School();
        course = new Course();
    }

    @Test
    public void testIteratorCourseIsEmpty() {
        Iterator courseIterator = school.getCourses();
        assertFalse(courseIterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorCourseIsNotRemoved() {
        school.addCourse(course);
        Iterator courseIterator = school.getCourses();
        Course courseIt = (Course) courseIterator.next();
        courseIterator.remove();
    }

}
