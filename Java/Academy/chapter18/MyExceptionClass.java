package chapter18;

import java.util.Scanner;

public class MyExceptionClass {

    private Scanner scanner = new Scanner(System.in);
    private User[] users = new User[10];
    private int cnt = 0;

    public static void main(String[] args) {
        MyExceptionClass myExceptionClass = new MyExceptionClass();
        while (true) {
            int age = 1;
            try {
                age = myExceptionClass.readAge();
            } catch (ReadAgeException e) {
                System.out.println(e.getMessage());
            }
            if (age == 0) {
                return;
            }
            myExceptionClass.printUsers();
        }

    }

    public int readAge() throws ReadAgeException {
        System.out.print("���� �Է�(����� 0): ");
        int age;
        age = scanner.nextInt();
        if (age < 0) {
            throw new ReadAgeException();
        }
        User user = new User();
        user.setAge(age);
        users[cnt++] = user;
        return age;
    }

    public void printUsers() {
        for (int i = 0; i < cnt; i++) {
            System.out.println(users[i].toString());
        }
    }

}
