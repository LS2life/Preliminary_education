package chapter11;

public class StringConcat {

    public static void main(String[] args) {
        String st1 = "Coffee";
        String st2 = "Bread";
        String st3 = st1 + " " + st2;
        System.out.println(st3);
        String st4 = st1.concat(st2);
        System.out.println(st4);
        String st5 = "Fresh ".concat(st3);
        System.out.println(st5);

    }

}
