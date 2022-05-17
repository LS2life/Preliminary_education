package chapter17;

public class PrintableInterface {

    public static void main(String[] args) {
        Printable printable = new Printer();
        printable.print("Hello Java");
    }

}
