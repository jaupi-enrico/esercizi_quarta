import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un double tra uno e due miliardi: ");
        double a = in.nextDouble();
        System.out.println("Inserisci un double tra uno e due miliardi: ");
        double b = in.nextDouble();

        // In questo caso funziona perchè il double è adatto a numeri più grandi

        System.out.println("Somma: " + (a + b));
        System.out.println("Differenza: " + (a - b));
        System.out.println("Prodotto: " + (a * b));
    }
}