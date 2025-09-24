import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci un numero: ");
        int N = in.nextInt();
        System.out.println("Inserisci una lettera: ");
        char C = in.next().charAt(0);
        for (int i = 0; i < N; i++) {
            if (i % 5 == 4) {
                System.out.println(C);
            }
            else {
                System.out.print(C);
            }
        }
    }
}