import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Inserici un numero: ");
            int n = in.nextInt();
            arr[i] = n;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");

        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}