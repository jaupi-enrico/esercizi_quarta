import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci un numero: ");
        int N = in.nextInt();
        int sumN = 0;
        float sum = 0;
        for (int i = 0; i < N; i++) {
            System.out.print("Inserisci il valore " + (i + 1) + ": ");
            float num = in.nextFloat();
            if (num > 100) {
                sum += num;
                sumN++;
            }
        }
        sum /= sumN;
        System.out.println("La media e': " + sum);
    }
}