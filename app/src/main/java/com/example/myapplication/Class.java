package com.example.myapplication;

import java.io.Serializable;

public class Class implements Serializable {
    private String className;
    private String classLocation;

    public Class(String className, String classLocation) {
        this.classLocation = classLocation;
        this.className =  className;
    }

    public String getClassName() {
        return className;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }
}
