package com.kajih.practice15;

public class Employee {

    private static int countId;

    private int id;
    private String name;
    private String emailAdd;
    private String add;

    {
        countId++;
    }

    public Employee(String name, String emailAdd, String add) {
        this.id = this.countId;
        this.name = name;
        this.emailAdd = emailAdd;
        this.add = add;
    }

    public static class Validator {
        public void showValidatedResult(Employee emp) {

            if (emp.name.isEmpty()) {
                System.out.printf("従業員ID %d に名前が設定されていません.\n", emp.id);
                return;
            }

            if (emp.emailAdd.isEmpty()) {
                System.out.printf("従業員ID %d にメールアドレスが設定されていません.\n", emp.id);
                return;
            }

            System.out.printf("従業員ID %d は正しく設定されています.\n", emp.id);

        }
    }

}