package com.wxfx.smart;

public class Circle {
    final double PI;
    //��Ű�� 1. �̸��浹�� ���� 2. ���� ����
    double rad;

    public Circle(double r) {
        rad = r;
        PI = 3.14;
    }

    public double getArea() {
        return (rad * rad) * PI;
    }
}
