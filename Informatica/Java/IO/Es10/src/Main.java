import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un numero tra uno e due miliardi: ");
        int a = in.nextInt();
        System.out.println("Inserisci un numero tra uno e due miliardi: ");
        int b = in.nextInt();

        // Non si possono usare gli int, bisogna usare i long
        /*
        *   long a = in.nextLong();
        *   long b = in.nextLong();
        */

        System.out.println("Somnma: " + (a + b));
        System.out.println("Differenza: " + (a - b));
        System.out.println("Prodotto: " + (a * b));
    }
}