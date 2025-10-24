import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci un numero massimo di 10: ");
        int n = in.nextInt();

        while (n > 10) {
            System.out.print("Reinserisci un numero massimo di 10: ");
            n = in.nextInt();
        }

        int[] a = new int[10];

        for (int i = 0; i < n; i++) {
            System.out.print("Inserisci il valore per la cella " + (i + 1) + ": ");
            a[i] = in.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                count++;
            }
        }
        System.out.print(count + " elementi pari: ");
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                System.out.print(a[i] + " ");
            }
        }
        System.out.print("\n");
        count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 1) {
                count++;
            }
        }
        System.out.print(count + " elementi dispari: ");
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 1) {
                System.out.print(a[i] + " ");
            }
        }
    }
}