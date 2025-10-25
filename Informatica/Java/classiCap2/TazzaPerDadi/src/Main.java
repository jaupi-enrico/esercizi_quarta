import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TazzaPerDadi tazza = null;
        int scelta;

        do {
            System.out.println("\n=== MENU TAZZA PER DADI ===");
            System.out.println("1. Crea tazza vuota");
            System.out.println("2. Crea tazza con N dadi da F facce");
            System.out.println("3. Aggiungi un dado");
            System.out.println("4. Lancia tutti i dadi");
            System.out.println("5. Mostra informazioni tazza");
            System.out.println("6. Mostra minimo e massimo punteggio possibile");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = in.nextInt();

            switch (scelta) {
                case 1 -> {
                    System.out.print("Quanti dadi può contenere al massimo? ");
                    int nMax = in.nextInt();
                    tazza = new TazzaPerDadi(nMax);
                    System.out.println("✅ Tazza creata con capacità massima di " + nMax + " dadi.");
                }
                case 2 -> {
                    System.out.print("Quanti dadi vuoi creare? ");
                    int N = in.nextInt();
                    System.out.print("Quante facce per dado? ");
                    int F = in.nextInt();
                    tazza = new TazzaPerDadi(N, F);
                    System.out.println("✅ Tazza creata con " + N + " dadi da " + F + " facce.");
                }
                case 3 -> {
                    if (tazza == null) {
                        System.out.println("⚠️ Prima crea una tazza!");
                        break;
                    }
                    System.out.print("Inserisci il numero di facce del dado: ");
                    int facce = in.nextInt();
                    Dado d = new Dado(facce);
                    if (tazza.add(d)) {
                        System.out.println("✅ Dado aggiunto!");
                    } else {
                        System.out.println("❌ Tazza piena!");
                    }
                }
                case 4 -> {
                    if (tazza == null || tazza.isEmpty()) {
                        System.out.println("⚠️ Nessun dado da lanciare!");
                        break;
                    }
                    int risultato = tazza.lancia();
                    System.out.println("🎲 Hai ottenuto un totale di: " + risultato);
                }
                case 5 -> {
                    if (tazza == null) {
                        System.out.println("⚠️ Nessuna tazza creata!");
                    } else {
                        System.out.println(tazza);
                    }
                }
                case 6 -> {
                    if (tazza == null) {
                        System.out.println("⚠️ Nessuna tazza creata!");
                    } else {
                        System.out.println("Minimo possibile: " + tazza.getMinimo());
                        System.out.println("Massimo possibile: " + tazza.getMassimo());
                    }
                }
                case 0 -> System.out.println("👋 Uscita dal programma...");
                default -> System.out.println("❌ Scelta non valida!");
            }
        } while (scelta != 0);

        in.close();
    }
}
