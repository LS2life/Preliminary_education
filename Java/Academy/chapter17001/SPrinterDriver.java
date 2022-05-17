package chapter17001;

public class SPrinterDriver implements Printable {

    @Override
    public void print(String doc) {
        System.out.println("From Samsung printer");
        System.out.println(doc);
    }

}
