package chapter07;

public class BankAccount2 {
    int balance = 0;

    public static void main(String[] args) {
        int num1 = 777;
        int num2 = num1;
        num2 = 888;
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        BankAccount2 ref1 = new BankAccount2();
        BankAccount2 ref2 = ref1;
        BankAccount2 ref3 = new BankAccount2();
        ref1.deposit(1000);
        ref2.deposit(2000);
        ref1.checkMyBalance();
    }

    public int deposit(int amount) {
        balance += amount;
        return balance;
    }

    public int withdraw(int amount) {
        balance -= amount;
        return balance;
    }

    public int checkMyBalance() {
        System.out.println("�ܾ�: " + balance);
        return balance;
    }
}























