package com.kajih.practice04;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Student yamamoto = new Student("山本", "一郎");
        Student jiro = new Student("", "次郎");
        Student tamada = new Student("山田", "太郎");
        Student yamashita = new Student("山下");

        try {
            studentList.addStudent(yamamoto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            studentList.addStudent(jiro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            studentList.addStudent(tamada);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            studentList.addStudent(yamashita);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        studentList.showAllStudents();
    }
}

class Student {
    public static int maxId;
    public int id;
    public String firstName;
    public String lastName;
    static {
        maxId = 0;
    }

    public Student(String firstName, String lastName) {
        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName) {
        this.id = ++maxId;
        this.firstName = firstName;
        this.lastName = null;
    }

    public boolean isValidFirstName() {
        return this.firstName != null
                && !this.firstName.isEmpty();
    }

    public boolean isValidLastName() {
        return this.lastName != null
                && !this.lastName.isEmpty();
    }
}

class StudentList {
    public List<Student> students;

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) throws AppException {
        if (!student.isValidFirstName()) {
            System.out.printf(
                    "ID %d: %s%s は登録できません. %n",
                    student.id,
                    student.firstName,
                    student.lastName);
            throw new AppException(" => 姓が空です. \n");
        }
        if (!student.isValidLastName()) {
            System.out.printf(
                    "ID %d: %s%s は登録できません. %n",
                    student.id,
                    student.firstName,
                    student.lastName);
            throw new AppException(" => 名が空です. \n");
        }
        if (student.isValidLastName()) {
            System.out.printf(
                    "ID %d: %s%s を登録しました. %n%n",
                    student.id,
                    student.firstName,
                    student.lastName);
            this.students.add(student);
        }
    }

    public void showAllStudents() {
        System.out.println("登録者一覧を表示します");
        System.out.println("-----");
        for (Student student : this.students) {
            System.out.printf(
                    "ID %d: %s%s %n",
                    student.id,
                    student.firstName,
                    student.lastName);
        }
    }
}
