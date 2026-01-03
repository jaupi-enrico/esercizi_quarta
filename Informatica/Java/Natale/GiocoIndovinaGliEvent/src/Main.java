import java.io.*;
import java.util.*;

public class Main {
    private static Map<String, String> mappaEventi = new HashMap<>();
    private static List<String> dateRimanenti = new ArrayList<>();
    private static int giocatoreCorrente = 1;
    private static int punteggio1 = 0;
    private static int punteggio2 = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        try (BufferedReader br = new BufferedReader(new FileReader("eventi.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    mappaEventi.put(parts[0], parts[1]);
                    dateRimanenti.add(parts[0]);
                }
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file CSV: " + e.getMessage());
            return;
        }

        System.out.println("Memorizza queste coppie <Data -> Evento>:");
        for (String data : dateRimanenti) {
            System.out.println(data + " -> " + mappaEventi.get(data));
        }
        System.out.println("\nHai 25 secondi per memorizzare...");
        Thread.sleep(25 * 1000);
        clearConsole();

        Random rand = new Random();
        while (!dateRimanenti.isEmpty()) {
            String dataCorrente = dateRimanenti.get(rand.nextInt(dateRimanenti.size()));
            System.out.println("Giocatore " + giocatoreCorrente + ", indovina l'evento per la data: " + dataCorrente);

            Set<String> scelteSet = new HashSet<>();
            scelteSet.add(mappaEventi.get(dataCorrente));
            List<String> eventi = new ArrayList<>(mappaEventi.values());
            while (scelteSet.size() < Math.min(4, eventi.size())) {
                scelteSet.add(eventi.get(rand.nextInt(eventi.size())));
            }
            List<String> scelte = new ArrayList<>(scelteSet);
            Collections.shuffle(scelte);

            for (int i = 0; i < scelte.size(); i++) {
                System.out.println((i + 1) + ". " + scelte.get(i));
            }

            int sceltaGiocatore = -1;
            while (sceltaGiocatore < 1 || sceltaGiocatore > scelte.size()) {
                System.out.print("Inserisci il numero della tua scelta: ");
                if (scanner.hasNextInt()) {
                    sceltaGiocatore = scanner.nextInt();
                } else {
                    scanner.next();
                }
            }

            if (scelte.get(sceltaGiocatore - 1).equals(mappaEventi.get(dataCorrente))) {
                System.out.println("Corretto!\n");
                if (giocatoreCorrente == 1) punteggio1++;
                else punteggio2++;
                dateRimanenti.remove(dataCorrente);
            } else {
                System.out.println("Sbagliato! Era: " + mappaEventi.get(dataCorrente) + "\n");
                giocatoreCorrente = giocatoreCorrente == 1 ? 2 : 1;
            }
        }

        System.out.println("Fine del gioco!");
        System.out.println("Punteggio: Giocatore 1 = " + punteggio1 + ", Giocatore 2 = " + punteggio2);
        if (punteggio1 > punteggio2) System.out.println("Vince il Giocatore 1!");
        else if (punteggio2 > punteggio1) System.out.println("Vince il Giocatore 2!");
        else System.out.println("Pareggio!");
    }

    private static void clearConsole() {
        for (int i = 0; i < 50; i++) System.out.println();
    }
}
