package chapter07;

//�޼ҵ� Ȯ�� Ŭ����
//�޼ҵ�-��� Ŭ����-������(����),���(�޼ҵ�)
public class BankAccount {
    //���� �ܾ�
    int balance = 0;

    //����Ʈ ������
    public BankAccount() {

    }

    public static void main(String[] args) {
        //Ŭ����-Ʋ, �ν��Ͻ�-�޸� �÷��� ��� �غ�
        //�ν��Ͻ� ����
        BankAccount yoon = new BankAccount();
        BankAccount p = new BankAccount();
        BankAccount park = new BankAccount();
        //�Ա�
        yoon.deposit(5000);
        p.deposit(3000);
        park.deposit(7000);
        //�ܾ���ȸ
        yoon.checkMyBalance();
        p.checkMyBalance();
    }

    //���(�޼ҵ�)
    //static-�޸𸮿� �÷��� ��� �غ�
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











