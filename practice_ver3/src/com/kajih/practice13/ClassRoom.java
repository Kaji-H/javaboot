package com.kajih.practice13;

public class ClassRoom {
    public static void main(String[] args) {

        Student[] students = {
                new Student("山本一郎", 3),
                new Student("山下次郎", 312),
                new Student("山口三郎", 79),
                new Student("山田太郎", 2),
        };
        students[0].showDetails();
        students[2].showDetails();
        students[3].showDetails();

    }
}
