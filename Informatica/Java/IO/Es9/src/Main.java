import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un float: ");
        float a = in.nextFloat();
        System.out.println("Inserisci un intero: ");
        int b = in.nextInt();
        System.out.println("Il prodotto tra i due e': " + a * b);
    }
}