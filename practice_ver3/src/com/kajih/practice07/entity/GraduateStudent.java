package com.kajih.practice07.entity;

public class GraduateStudent {

    private int id;
    private String name;
    private String department;

    public GraduateStudent(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
