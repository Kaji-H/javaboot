package com.kajih.practice07.entity;

import java.util.ArrayList;
import java.util.List;

public class Department {

    String name;
    List<GraduateStudent> students = new ArrayList<>();

    public Department(String name, List<GraduateStudent> students) {
        this.name = name;
        this.students.addAll(students);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GraduateStudent> getStudents() {
        return students;
    }

    public void addStudent(GraduateStudent student) {
        this.students.add(student);
    }

    public void addStudents(List<GraduateStudent> students) {
        this.students.addAll(students);
    }

}
