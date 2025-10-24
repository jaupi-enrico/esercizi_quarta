import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int a = in.nextInt();
        System.out.print("Inserisci un numero: ");
        int b = in.nextInt();

        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Inserici un numero tra " + a + " e " + b + ": ");
            int n = in.nextInt();
            while (n > b || n < a) {
                System.out.print("Reinserici un numero tra " + a + " e " + b + ": ");
                n = in.nextInt();
            }
            arr[i] = n;
        }

        int m = (a + b) / 2;

        System.out.print("Elementi tra a e m: ");
        for (int i = 0; i < 10; i++) {
            if (arr[i] <= m) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.print("\n");

        System.out.print("Elementi tra m e b: ");
        for (int i = 0; i < 10; i++) {
            if (arr[i] > m) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}