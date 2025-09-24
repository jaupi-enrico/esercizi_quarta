import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci un numero: ");
        int N = in.nextInt();
        System.out.print("Inserisci un float: ");
        float A = in.nextFloat();
        System.out.print("Inserisci un float: ");
        float B = in.nextFloat();
        if (A > B) {
            float temp = A;
            A = B;
            B = temp;
        }
        int nBetween = 0;
        for (int i = 0; i < N; i++) {
            System.out.print("Inserisci il valore " + (i + 1) + ": ");
            float num = in.nextFloat();
            if (num > A && num < B) {
                nBetween++;
            }
        }
        System.out.println("Hai inserito " + nBetween + " valori tra A e B");
    }
}