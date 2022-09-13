import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.print("What is your name? : ");
        name = sc.nextLine();

        System.out.println("Hello, " + name + " !");
        sc.close();

    }
}
