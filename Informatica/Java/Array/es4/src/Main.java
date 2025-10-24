import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] arr = new int[10];

        System.out.print("Inserici un numero: ");
        int n = in.nextInt();
        arr[0] = n;
        for (int i = 1; i < 10 && arr[i - 1] >= 0; i++) {
            System.out.print("Inserici un numero: ");
            n = in.nextInt();
            arr[i] = n;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(arr[9 - i] + " ");
        }
    }
}