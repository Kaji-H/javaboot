package com.kajih.practice07.entity;

import java.util.ArrayList;
import java.util.List;

public class Institute {

    private String name;
    private List<Department> departments = new ArrayList<>();

    public Institute(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalStudentsInInstitute() {
        int totalStudents = 0;

        for (Department department : departments) {
            totalStudents += department.getStudents().size();
        }

        return String.valueOf(totalStudents);
    }

}
