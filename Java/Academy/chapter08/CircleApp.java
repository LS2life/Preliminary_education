package chapter08;

import java.util.Scanner;

//import java.util.*;
//*-all

import com.wxfx.smart.Circle;

public class CircleApp {
    private final String getUsersSql = "select * from tableName";

    public static void main(String[] args) {
        Circle circle = new Circle(4);
        System.out.println("���� ����: " + circle.getArea());
        com.fxmx.simple.Circle circle2 =
                new com.fxmx.simple.Circle(4);
        System.out.println("���� �ѷ�: " + circle2.getPerimeter());
        //ctrl+shift+o->�ڵ� ����Ʈ
        Scanner scanner = new Scanner(System.in);
    }
}











