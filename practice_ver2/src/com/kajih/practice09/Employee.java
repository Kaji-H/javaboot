package com.kajih.practice09;

public class Employee {

    private int id;
    private String name;
    private int age;
    private Division division;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public void showDetails() {
        System.out.printf("従業員ID:%d %s（%d 歳）さんは、部署ID:%d の %s 所属です. %n", this.id, this.name, this.age,
                this.division.getId(), this.division.getName());
    }

}
