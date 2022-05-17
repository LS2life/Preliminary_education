package com.fxmx.simple;

public class Circle {
    final double PI;
    double rad;

    public Circle(double r) {
        rad = r;
        PI = 3.14;
    }

    public double getPerimeter() {
        return (rad * 2) * PI;
    }
}
