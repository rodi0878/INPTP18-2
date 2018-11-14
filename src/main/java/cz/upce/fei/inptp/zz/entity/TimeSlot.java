package cz.upce.fei.inptp.zz.entity;

import java.util.Objects;

public class TimeSlot {
    
    private Day day;
    private int hour;
    
    // TODO: is this clear?
    private int duration;
    
    public TimeSlot(Day day, int hour, int duration) {
        this.day = day;
        this.hour = hour;
        this.duration = duration;
    }

    public Day getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.day);
        hash = 79 * hash + this.hour;
        hash = 79 * hash + this.duration;
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
        if (this.hour != other.getHour()) {
            return false;
        }
        if (this.duration != other.getDuration()) {
            return false;
        }
        if (this.day != other.getDay()) {
            return false;
        }
        return true;
    }
    
    
}
