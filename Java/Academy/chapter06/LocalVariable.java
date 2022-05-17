package chapter06;

public class LocalVariable {
    public static void main(String[] args) {
        int age = 0;
        showAge(24, false);
    }

    public static void showAge(int ageK, boolean birthPassed) {
        int age = 0;
        if (birthPassed) {
            age = ageK - 1;
        } else {
            age = ageK - 2;
        }
        System.out.println("�� ����:" + age);
    }

}










