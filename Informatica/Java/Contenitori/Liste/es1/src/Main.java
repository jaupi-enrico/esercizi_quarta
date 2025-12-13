import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedList<String> arr = new LinkedList<>();

        String parola;
        System.out.print("Inserisci parola: ");
        while (!(parola = in.next()).equals("stop")) {
            int scelta;
            System.out.print("Con (1) o senza (2) posizione? ");
            scelta = in.nextInt();
            if (scelta == 1) {
                System.out.print("Inserisci la posizione: ");
                scelta = in.nextInt();
                arr.add(scelta, parola);
            }
            else if (scelta == 2) {
                arr.add(parola);
            }
            else {
                System.out.println("Opzione non valida");
            }
            System.out.print("Inserisci parola: ");
        }
        System.out.println(arr);
        in.close();
    }
}