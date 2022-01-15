package com.kajiH.Intermediate.practice04.practice0401;

public class Figure {

    private double base;
    private double height;

    public Figure(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void calcTryangleArea() {
        double area = this.base * this.height / 2;

        System.out.printf("底辺が %.1f cm で、高さが %.1f cm の三角形の面積 => %.1f\n", this.base, this.height, area);
    }

}
