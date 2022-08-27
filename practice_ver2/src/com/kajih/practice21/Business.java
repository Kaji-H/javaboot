package com.kajih.practice21;

import com.kajih.practice21.Data.Division;
import com.kajih.practice21.Data.Employee;

public class Business {
    public static void main(String[] args) {
        Division division = new Division()
                .id(7)
                .name("ゲーム事業部");
        Employee employee = new Employee()
                .id(777)
                .name("山本一郎")
                .age(171)
                .division(division);
        employee.showDetails();
    }
}
