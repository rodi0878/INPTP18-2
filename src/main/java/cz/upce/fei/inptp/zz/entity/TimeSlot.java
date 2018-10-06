/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.Objects;

/**
 *
 * @author Roman
 */
public class TimeSlot {
    
    // TODO: handle this on different place, use standard library?
    public enum Day {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturdy,
        Sundy
    }
    
    Day day;
    int hour;
    // TODO: is this clear?
    int duration;

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
        if (this.hour != other.hour) {
            return false;
        }
        if (this.duration != other.duration) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        return true;
    }
    
    
}
