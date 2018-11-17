/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roman
 */
public class Teacher extends Person {

    private List<CourseAction> actions;

    public Teacher() {
        actions = new ArrayList<>();
    }

    public List<CourseAction> getActions() {
        return actions;
    }

    public void setActions(List<CourseAction> actions) {
        this.actions = actions;
    }
}
