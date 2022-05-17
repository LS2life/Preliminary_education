package chapter07001;

public class FirstStringIntro {
    public static void main(String[] args) {
        String str1 = "Happy";
        String str2 = new String("Birthday");
        System.out.println(str1 + " " + str2);
        printString(str1);
        printString(" ");
        printString(str2);
        printString("\n");
        printString("End of program! \n");
        printString(new String("Instance"));
    }

    public static void printString(String str) {
        System.out.print(str);
    }
}
