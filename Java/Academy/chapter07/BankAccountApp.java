package chapter07;

public class BankAccountApp {

    public static void main(String[] args) {
        //�޼ҵ� �Ű������� �ν��Ͻ��� ���� ���� ���� �ν��Ͻ��� �����Ѵ�
        BankAccount bankAccount = new BankAccount();
        BankAccount2 bankAccount2 = new BankAccount2();
        bankAccount2.deposit(3000);
        bankAccount2.withdraw(300);
//		check(bankAccount2);
//		check(bankAccount);
        check(new BankAccount2());
        //null-����. ��� �ִ�.
        BankAccount2 bankAccount2001 = null;
        System.out.println(bankAccount2001);
        bankAccount2 = null;
        if (bankAccount2 == null) {
            bankAccount2 = new BankAccount2();
        }
    }

    public static void check(BankAccount2 ba2) {
        //ba2=bankAccount2;
        ba2.checkMyBalance();
    }

}






