import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un intero: ");
        int a = in.nextInt();
        System.out.println("I multipli sono: " + a * 10 + " " + a * 100 + " " + a * 1000);
    }
}