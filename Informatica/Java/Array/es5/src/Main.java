import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] arr = new int[50];

        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Inserici un numero: ");
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}