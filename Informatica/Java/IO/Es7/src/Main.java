import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un float: ");
        float a = in.nextFloat();
        System.out.println("Il numero diviso per un miliardo e': " + a / 1000000000);
    }
}