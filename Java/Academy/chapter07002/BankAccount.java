package chapter07002;

//VO,DTO
public class BankAccount {

    private String accNumber;
    private String ssNumber;
    private int balance;

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccNumber("12-34-56");
        String str = bankAccount.getAccNumber();
        System.out.println(str);
    }

    //getter setter, �Դ� ����
    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    //��Ŭ��-�ҽ�-���ʷ����� �Դ� ����
    public String getSsNumber() {
        return ssNumber;
    }

    public void setSsNumber(String ssNumber) {
        this.ssNumber = ssNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}









