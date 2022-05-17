package chapter07001;

public class BankAccount {
    //����-private �޼ҵ�-public
    private String accNumber;//���¹�ȣ
    private String ssNumber;//�ֹι�ȣ
    private int balance;

    //������ �޼ҵ� - Ŭ���� �̸��� ����, ���� Ÿ�� �κ� ����
    public BankAccount(String acc, String ss, int bal) {
        accNumber = acc;
        ssNumber = ss;
        balance = bal;
    }

    //getter setter
    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public int deposit(int amount) {
        //balance=balance+amout
        balance += amount;
        return balance;
    }

    public int withdraw(int amount) {
        balance -= amount;
        return balance;
    }

    //172p
    public int checkMyBalance() {
        System.out.println("���¹�ȣ: " + accNumber);
        System.out.println("�ֹι�ȣ: " + ssNumber);
        System.out.println("�ܾ�: " + balance);
        return balance;
    }

}










