package cz.upce.fei.inptp.zz.entity;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeSlotTest {
    
    @Test
    public void testSameSlotsShouldBeEqual() {
        Day day = Day.FRIDAY;
        int hour = 8;
        int duration = 7;
        TimeSlot ta = new TimeSlot(day, hour, duration);
        TimeSlot tb = new TimeSlot(day, hour, duration);
        
        assertEquals(ta, tb);
    }
    
    @Test
    public void testDifferentDaysShouldNotBeEqual() {
        Day friday = Day.FRIDAY;
        Day sunday = Day.SUNDAY;
        int hour = 8;
        int duration = 7;
        
        TimeSlot ta = new TimeSlot(friday, hour, duration);
        TimeSlot tb = new TimeSlot(sunday, hour, duration);
        
        assertNotEquals(ta, tb);
    }
    
    @Test
    public void testDifferentHoursShouldNotBeEqual() {
        Day day = Day.FRIDAY;
        int hour_a = 8;
        int hour_b = 12;
        int duration = 7;
        
        TimeSlot ta = new TimeSlot(day, hour_a, duration);
        TimeSlot tb = new TimeSlot(day, hour_b, duration);
        
        assertNotEquals(ta, tb);
    }
    
    @Test
    public void testDifferentDurationsShouldNotBeEqual() {
        Day day = Day.FRIDAY;
        int hour = 8;
        int duration_a = 7;
        int duration_b = 12;
        
        TimeSlot ta = new TimeSlot(day, hour, duration_a);
        TimeSlot tb = new TimeSlot(day, hour, duration_b);
        
        assertNotEquals(ta, tb);
    }
    
}
