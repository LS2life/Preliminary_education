package chapter17001;

public class PrinterDriver {

    public static void main(String[] args) {
        String myDoc = "This is a report about...";
        //�Ｚ �����ͷ� ���
        Printable prn = new SPrinterDriver();
        prn.print(myDoc);

        //LG �����ͷ� ���
        prn = new LPrinterDriver();
        prn.print(myDoc);
    }

}
