package chapter07001;

public class BankAccountConstructor {
    public static void main(String[] args) {
        BankAccount yoon = new BankAccount("12-34-89",
                "990990-9090990", 10000);
//		yoon.accNumber="12-34-56";
        yoon.deposit(5000);
        yoon.checkMyBalance();
    }

}
