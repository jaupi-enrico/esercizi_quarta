import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci un numero: ");
        int N = in.nextInt();
        float sum = 0;
        for (int i = 0; i < N; i++) {
            System.out.print("Inserisci il valore " + (i + 1) + ": ");
            sum += in.nextFloat();
        }
        sum /= N;
        System.out.println("La media e': " + sum);
    }
}