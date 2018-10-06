/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Roman
 */
public class Course {
    String title;
    String description;
    List<CourseAction> actions;

    public Course() {
        actions = new ArrayList<>();
    }
    
}
