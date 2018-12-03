package cz.upce.fei.inptp.zz.entity;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeSlotTest {

    @Test
    public void testSameSlotsShouldBeEqual() {
        Day day = Day.FRIDAY;
        int startHour = 8;
        int endHour = 9;
        TimeSlot ta = new TimeSlot(day, startHour, endHour);
        TimeSlot tb = new TimeSlot(day, startHour, endHour);

        assertEquals(ta, tb);
    }

    @Test
    public void testDifferentDaysShouldNotBeEqual() {
        Day friday = Day.FRIDAY;
        Day sunday = Day.SUNDAY;
        int startHour = 8;
        int endHour = 9;

        TimeSlot ta = new TimeSlot(friday, startHour, endHour);
        TimeSlot tb = new TimeSlot(sunday, startHour, endHour);

        assertNotEquals(ta, tb);
    }

    @Test
    public void testDifferentStartHoursShouldNotBeEqual() {
        Day day = Day.FRIDAY;
        int startHour_a = 8;
        int startHour_b = 12;
        int endHour = 13;

        TimeSlot ta = new TimeSlot(day, startHour_a, endHour);
        TimeSlot tb = new TimeSlot(day, startHour_b, endHour);

        assertNotEquals(ta, tb);
    }

    @Test
    public void testDifferentEndHoursShouldNotBeEqual() {
        Day day = Day.FRIDAY;
        int startHour = 8;
        int endHour_a = 9;
        int endHour_b = 12;

        TimeSlot ta = new TimeSlot(day, startHour, endHour_a);
        TimeSlot tb = new TimeSlot(day, startHour, endHour_b);

        assertNotEquals(ta, tb);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStartHourIsNotCorrect() {
        TimeSlot t = new TimeSlot(Day.MONDAY, -1, 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEndHourIsNotCorrect() {
        TimeSlot t = new TimeSlot(Day.MONDAY, 8, 25);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEndHourIsLessThanStartHourThrowsException() {
        TimeSlot t = new TimeSlot(Day.MONDAY, 10, 9);
    }

    @Test
    public void testSameTimeSlotsAreOverlapping() {
        TimeSlot t_a = new TimeSlot(Day.MONDAY, 9, 11);
        TimeSlot t_b = new TimeSlot(Day.MONDAY, 9, 11);

        assertTrue(t_a.isOverlappingWithOtherTimeslot(t_b));
    }

    @Test
    public void testTimeSlotsWithSameDayAndStartHourAreOverlapping() {
        TimeSlot t_a = new TimeSlot(Day.MONDAY, 9, 11);
        TimeSlot t_b = new TimeSlot(Day.MONDAY, 9, 12);

        assertTrue(t_a.isOverlappingWithOtherTimeslot(t_b));
    }

    @Test
    public void testTimeSlotsWithSameDayAndEndHourAreOverlapping() {
        TimeSlot t_a = new TimeSlot(Day.MONDAY, 10, 12);
        TimeSlot t_b = new TimeSlot(Day.MONDAY, 9, 12);

        assertTrue(t_a.isOverlappingWithOtherTimeslot(t_b));
    }

    @Test
    public void testTimeSlotsWithDifferentStartAndEndHoursAreOverlapping() {
        TimeSlot t_a = new TimeSlot(Day.MONDAY, 10, 13);
        TimeSlot t_b = new TimeSlot(Day.MONDAY, 11, 12);

        assertTrue(t_a.isOverlappingWithOtherTimeslot(t_b));
    }

    @Test
    public void testTimeSlotsWithDifferentDayAreNotOverlapping() {
        TimeSlot t_a = new TimeSlot(Day.FRIDAY, 10, 13);
        TimeSlot t_b = new TimeSlot(Day.MONDAY, 10, 13);

        assertFalse(t_a.isOverlappingWithOtherTimeslot(t_b));
    }

    @Test
    public void testDifferentTimeSlotsOnSameDayAreNotOverlapping_TA_TB() {
        TimeSlot t_a = new TimeSlot(Day.FRIDAY, 8, 10);
        TimeSlot t_b = new TimeSlot(Day.MONDAY, 12, 15);

        assertFalse(t_a.isOverlappingWithOtherTimeslot(t_b));
    }

    @Test
    public void testDifferentTimeSlotsOnSameDayAreNotOverlapping_TB_TA() {
        TimeSlot t_a = new TimeSlot(Day.FRIDAY, 8, 10);
        TimeSlot t_b = new TimeSlot(Day.MONDAY, 12, 15);

        assertFalse(t_b.isOverlappingWithOtherTimeslot(t_a));
    }
}
