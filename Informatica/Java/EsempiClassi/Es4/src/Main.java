import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GeneratoreAutoIncrementale generatore = null;
        Scanner in = new Scanner(System.in);
        int scelta = -2;
        while (scelta != -1) {
            System.out.println("Inserisci la tua scelta:");
            System.out.println("1) Nuovo generatore");
            System.out.println("2) Genera numero");
            System.out.println("3) Stato del generatore");
            System.out.println("-1) Exit");
            System.out.print("Scelta: ");
            scelta = in.nextInt();
            switch (scelta) {
                case 1:
                    System.out.print("Valore alpha: ");
                    String alpha = in.next();
                    System.out.print("Numero di cifre: ");
                    long cifre = in.nextLong();
                    generatore = new GeneratoreAutoIncrementale(alpha, cifre);
                    break;
                case 2:
                    if (generatore != null) {
                        System.out.println(generatore.genera());
                    }
                    else {
                        System.out.println("Il generatore non esiste");
                    }
                    break;
                case 3:
                    if (generatore != null) {
                        System.out.println(generatore.toString());
                    }
                    else {
                        System.out.println("Il generatore non esiste");
                    }
                    break;
            }
        }
    }
}
