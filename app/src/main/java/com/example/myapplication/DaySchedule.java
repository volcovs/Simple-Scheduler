package com.example.myapplication;

import java.io.Serializable;
import java.util.ArrayList;

public class DaySchedule implements Serializable {
    private ArrayList<Class> classes;


    public DaySchedule() {
        this.classes = new ArrayList<>();

        //8-10
        classes.add(new Class("", ""));
        //10-12
        classes.add(new Class("", ""));
        //12-14
        classes.add(new Class("", ""));
        //14-16
        classes.add(new Class("", ""));
        //16-18
        classes.add(new Class("", ""));
        //18-20
        classes.add(new Class("", ""));
        //20-22
        classes.add(new Class("", ""));
    }

    public DaySchedule(ArrayList<Class> classes) {
        this.classes = classes;
    }


    public ArrayList<Class> getClasses() {
        return this.classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

}
