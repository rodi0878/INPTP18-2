package cz.upce.fei.inptp.zz.entity;

import java.util.Objects;

public class TimeSlot {

    private Day day;
    private static final int MIN_HOUR = 8;
    private static final int MAX_HOUR = 20;
    private int startHour = MIN_HOUR;
    private int endHour = MAX_HOUR;

    public TimeSlot(Day day, int startHour, int endHour) throws IllegalArgumentException {
        this.day = day;

        if (isStartHourCorrect(startHour)) {
            this.startHour = startHour;
        } else {
            throw new IllegalArgumentException("Argument startHour is not correct!");
        }

        if (isEndHourCorrect(endHour)) {
            this.endHour = endHour;
        } else {
            throw new IllegalArgumentException("Argument endHour is not correct!");
        }
    }

    public Day getDay() {
        return day;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    private boolean isStartHourCorrect(int startHour) {
        return startHour < endHour && startHour >= MIN_HOUR && startHour < MAX_HOUR;
    }

    private boolean isEndHourCorrect(int endHour) {
        return endHour > startHour && endHour > MIN_HOUR && endHour <= MAX_HOUR;
    }

    public boolean isOverlappingWithOtherTimeslot(TimeSlot timeSlot) {
        if (day.equals(timeSlot.getDay())) {
            return startHour < timeSlot.getEndHour() && timeSlot.getStartHour() < getEndHour();
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.day);
        hash = 79 * hash + this.startHour;
        hash = 79 * hash + this.endHour;
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
        if (this.startHour != other.getStartHour()) {
            return false;
        }
        if (this.endHour != other.getEndHour()) {
            return false;
        }
        if (this.day != other.getDay()) {
            return false;
        }
        return true;
    }
}
