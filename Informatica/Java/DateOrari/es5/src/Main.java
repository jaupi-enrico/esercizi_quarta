import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LocalDate[] date = new LocalDate[3];
        System.out.println("Inserisci 3 date (formato: AAAA-MM-GG):");

        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + ": ");
            String input = in.next();
            date[i] = LocalDate.parse(input); // formato: yyyy-MM-dd
        }

        System.out.println("\nScegli un'opzione:");
        System.out.println("1 → Cerca per giorno");
        System.out.println("2 → Cerca per mese");
        System.out.println("3 → Cerca per anno");
        System.out.print("Scelta: ");
        int scelta = in.nextInt();

        int giorno = -1, mese = -1, anno = -1;

        switch (scelta) {
            case 1: {
                System.out.print("Inserisci il giorno: ");
                giorno = in.nextInt();
                break;
            }
            case 2: {
                System.out.print("Inserisci il mese: ");
                mese = in.nextInt();
                break;
            }
            case 3: {
                System.out.print("Inserisci l'anno: ");
                anno = in.nextInt();
                break;
            }
            default: {
                System.out.println("Scelta non valida.");
                return;
            }
        }

        System.out.println("\nDate corrispondenti:");
        boolean trovata = false;
        for (LocalDate d : date) {
            if ((giorno != -1 && d.getDayOfMonth() == giorno) ||
                    (mese != -1 && d.getMonthValue() == mese) ||
                    (anno != -1 && d.getYear() == anno)) {
                System.out.println(d);
                trovata = true;
            }
        }

        if (!trovata)
            System.out.println("Nessuna data corrisponde al criterio scelto.");

        in.close();
    }
}