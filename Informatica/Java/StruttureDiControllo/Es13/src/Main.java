import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci un numero: ");
        int N = in.nextInt();
        System.out.println("Inserisci un numero: ");
        int M = in.nextInt();
        for (int i = 0; i < N*M; i++) {
            if (i % M == M - 1) {
                System.out.println('x');
            }
            else {
                System.out.print('x');
            }
        }
    }
}