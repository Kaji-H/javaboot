package com.kajih.practice09;

public class Business {
    public static void main(String[] args) {
        Division division = new Division();
        division.setId(7);
        division.setName("ゲーム事業部");

        Employee employee = new Employee();
        employee.setId(777);
        employee.setName("山本一郎");
        employee.setAge(171);
        employee.setDivision(division);

        employee.showDetails();
    }
}
