import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Mastermind gioco = new Mastermind();

        System.out.println("=== MASTERMIND ===");
        System.out.println("Colori disponibili:");
        System.out.println("B = Bianco, N = Nero, V = Verde, G = Giallo, R = Rosso, A = Arancione");
        System.out.println("Inserisci 4 lettere separate da spazio (es: V B N G)");
        System.out.println("DEBUG segreta: " + gioco.getSequenzaNascosta());
        System.out.println();

        while (!gioco.vittoria() && !gioco.terminato()) {

            System.out.print("Tentativo " + (gioco.getTentativiEffettuati() + 1) + ": ");

            int c1 = leggiColore(sc);
            int c2 = leggiColore(sc);
            int c3 = leggiColore(sc);
            int c4 = leggiColore(sc);

            Sequenza tentativo = new Sequenza(c1, c2, c3, c4);
            gioco.add(tentativo);

            System.out.println(gioco);
        }

        if (gioco.vittoria()) {
            System.out.println("HAI VINTO!");
            System.out.println("Tentativi usati: " + gioco.getTentativiEffettuati());
        } else {
            System.out.println("HAI PERSO!");
            System.out.println("La sequenza era: " + gioco.getSequenzaNascosta());
        }

        sc.close();
    }

    private static int leggiColore(Scanner sc) {
        while (true) {
            String s = sc.next().toUpperCase();
            switch (s) {
                case "B": return Colore.BIANCO;
                case "N": return Colore.NERO;
                case "V": return Colore.VERDE;
                case "G": return Colore.GIALLO;
                case "R": return Colore.ROSSO;
                case "A": return Colore.ARANCIONE;
                default:
                    System.out.print("Colore non valido, riprova: ");
            }
        }
    }
}
