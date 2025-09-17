import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un intero: ");
        int a = in.nextInt();
        System.out.println("Inserisci un float: ");
        float b = in.nextFloat();
        System.out.println("Inserisci un double: ");
        double c = in.nextDouble();
        System.out.println("I numeri inseriti sono " + c + " " + b + " " + a);
    }
}