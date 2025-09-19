import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if (a > b) {
            System.out.println("Il primo e' piu' grande");
        }
        else {
            System.out.println("Il secondo e' piu' grande");
        }
    }
}