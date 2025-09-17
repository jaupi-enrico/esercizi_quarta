import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un intero: ");
        int a = in.nextInt();
        System.out.println("Il numero moltiplicato e': " + a * 100);
        System.out.println("Il numero diviso e': " + a / 10);
        System.out.println("Il resto della divisione per 3 e': " + a % 3);
    }
}