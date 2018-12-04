package cz.upce.fei.inptp.zz.entity;

import java.util.Objects;

public class TimeSlot {

    private Day day;
    private int hourOfTimeSlotStart = 0;
    private int hourOfTimeSlotEnd = 23;

    public TimeSlot(Day day, int hourOfTimeSlotStart, int hourOfTimeSlotEnd)
            throws IllegalArgumentException {

        if (!areBothHourArgumentsCorrect(hourOfTimeSlotStart, hourOfTimeSlotEnd)) {
            throw new IllegalArgumentException("Hour arguments are not correct!");
        }

        this.day = day;
        this.hourOfTimeSlotEnd = hourOfTimeSlotEnd;
        this.hourOfTimeSlotStart = hourOfTimeSlotStart;
    }

    public Day getDay() {
        return day;
    }

    public int getHourOfTimeSlotStart() {
        return hourOfTimeSlotStart;
    }

    public int getHourOfTimeSlotEnd() {
        return hourOfTimeSlotEnd;
    }

    private boolean areBothHourArgumentsCorrect(int startHour, int endHour) {
        return (startHour >= 0 && startHour < endHour)
                && (endHour <= 23 && endHour > startHour);
    }

    public boolean isOverlappingWithOtherTimeslot(TimeSlot timeSlot) {
        if (day.equals(timeSlot.getDay())) {
            return hourOfTimeSlotStart < timeSlot.getHourOfTimeSlotEnd()
                    && timeSlot.getHourOfTimeSlotStart() < getHourOfTimeSlotEnd();
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.day);
        hash = 79 * hash + this.hourOfTimeSlotStart;
        hash = 79 * hash + this.hourOfTimeSlotEnd;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeSlot other = (TimeSlot) obj;
        if (this.hourOfTimeSlotStart != other.getHourOfTimeSlotStart()) {
            return false;
        }
        if (this.hourOfTimeSlotEnd != other.getHourOfTimeSlotEnd()) {
            return false;
        }
        if (this.day != other.getDay()) {
            return false;
        }
        return true;
    }
}
