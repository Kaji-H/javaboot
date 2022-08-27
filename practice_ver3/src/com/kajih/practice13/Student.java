package com.kajih.practice13;

public class Student {

    private static int studentsNum = 0;

    private String name;
    private int age;
    private int id;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++studentsNum;
    }

    public void showDetails() {
        System.out.printf("フリスタ大学 [生徒ID %d] 名前: %s, 年齢: %d 歳\n", this.id, this.name, this.age);
    }

}
