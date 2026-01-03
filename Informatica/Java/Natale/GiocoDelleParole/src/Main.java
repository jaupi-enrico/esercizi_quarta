import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String parola = "marmellata";
        ArrayList<Character> lettereIndovinate = new ArrayList<>();
        ArrayList<Character> lettereUsate = new ArrayList<>();

        for (int i = 0; i < parola.length(); i++) {
            lettereIndovinate.add('_');
        }

        Fiore fiore = new Fiore("stati_fiore.txt");
        boolean vinta = false;

        while (!fiore.haPerso() && !vinta) {
            System.out.print("Parola: ");
            for (char c : lettereIndovinate) System.out.print(c + " ");
            System.out.println();

            System.out.print("Inserisci la lettera: ");
            char l = sc.next().toLowerCase().charAt(0);

            if (lettereUsate.contains(l)) {
                System.out.println("Lettera già usata!");
                continue;
            }

            lettereUsate.add(l);

            boolean trovata = false;
            for (int i = 0; i < parola.length(); i++) {
                if (parola.charAt(i) == l) {
                    lettereIndovinate.set(i, l);
                    trovata = true;
                }
            }

            if (!trovata) {
                System.out.println("Lettera sbagliata!");
                fiore.aumentaErrore();
            }

            fiore.mostraFiore();

            vinta = !lettereIndovinate.contains('_');
        }

        if (vinta) {
            System.out.println("Hai indovinato la parola: " + parola);
        } else {
            System.out.println("Hai perso! La parola era: " + parola);
        }
    }
}
