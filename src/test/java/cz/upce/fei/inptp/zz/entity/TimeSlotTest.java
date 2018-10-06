/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roman
 */
public class TimeSlotTest {
    
    @Test
    public void testSameSlotsShouldBeEqual() {
        TimeSlot ta = new TimeSlot();
        TimeSlot tb = new TimeSlot();
        
        tb.day = ta.day = TimeSlot.Day.Friday;
        tb.duration = ta.duration = 7;
        tb.hour = ta.hour = 8;
        
        assertEquals(ta, tb);
    }
    
    @Test
    public void testDifferentSlotsShouldNotBeEqual() {
        TimeSlot ta = new TimeSlot();
        TimeSlot tb = new TimeSlot();
            
        tb.day = ta.day = TimeSlot.Day.Friday;
        tb.duration = 1;
        ta.duration = 2;
        tb.hour = ta.hour = 8;
        
        assertNotEquals(ta, tb);
    }
    
}
