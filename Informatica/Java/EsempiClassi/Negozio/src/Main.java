import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Coda coda = new Coda();

    public static void main(String[] args) {

        int scelta;
        do {
            stampaMenu();
            scelta = leggiInt("Scelta: ");

            switch (scelta) {
                case 1 -> aggiungiCliente();
                case 2 -> visualizzaClienti();
                case 3 -> aggiungiArticoloCliente();
                case 4 -> visualizzaTotaleCliente();
                case 5 -> pagaCliente();
                case 0 -> System.out.println("Arrivederci!");
                default -> System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);
    }

    private static void stampaMenu() {
        System.out.println("\n===== SUPERMERCATO =====");
        System.out.println("1. Aggiungi cliente alla coda");
        System.out.println("2. Visualizza clienti in coda");
        System.out.println("3. Aggiungi articolo a un cliente");
        System.out.println("4. Visualizza totale carrello cliente");
        System.out.println("5. Paga cliente (rimuove dalla coda)");
        System.out.println("0. Esci");
    }


    private static void aggiungiCliente() {
        System.out.print("Nome cliente: ");
        String nome = sc.nextLine();
        coda.aggiungi(new Cliente(nome));
        System.out.println("Cliente aggiunto alla coda.");
    }

    private static void visualizzaClienti() {
        ArrayList<Cliente> clienti = coda.visualizzaClienti();

        if (clienti.isEmpty()) {
            System.out.println("Nessun cliente in coda.");
            return;
        }

        int i = 1;
        for (Cliente c : clienti) {
            System.out.println(i++ + ") " + c.getNome() +
                    " | Punti: " + c.getPunti());
        }
    }

    private static void aggiungiArticoloCliente() {
        ArrayList<Cliente> clienti = coda.visualizzaClienti();
        if (clienti.isEmpty()) {
            System.out.println("Coda vuota.");
            return;
        }

        visualizzaClienti();
        int scelta = leggiInt("Scegli cliente: ") - 1;

        if (scelta < 0 || scelta >= clienti.size()) {
            System.out.println("Cliente non valido.");
            return;
        }

        Cliente c = clienti.get(scelta);

        System.out.print("Codice articolo: ");
        String cod = sc.nextLine();

        System.out.print("Descrizione: ");
        String desc = sc.nextLine();

        double prezzo = leggiDouble("Prezzo: ");

        c.getCarrello().aggiungiArticolo(new Articolo(cod, desc, prezzo));
        System.out.println("Articolo aggiunto.");
    }

    private static void visualizzaTotaleCliente() {
        ArrayList<Cliente> clienti = coda.visualizzaClienti();
        if (clienti.isEmpty()) {
            System.out.println("Coda vuota.");
            return;
        }

        visualizzaClienti();
        int scelta = leggiInt("Scegli cliente: ") - 1;

        if (scelta < 0 || scelta >= clienti.size()) {
            System.out.println("Cliente non valido.");
            return;
        }

        Cliente c = clienti.get(scelta);
        System.out.println("Totale carrello: " +
                c.getCarrello().calcolaTotaleCarrello() + " €");
    }

    private static void pagaCliente() {
        ArrayList<Cliente> clienti = coda.visualizzaClienti();
        if (clienti.isEmpty()) {
            System.out.println("Coda vuota.");
            return;
        }

        Cliente c = clienti.get(0); // primo della coda
        double totale = c.getCarrello().calcolaTotaleCarrello();

        System.out.println("Cliente: " + c.getNome());
        System.out.println("Totale da pagare: " + totale + " €");

        coda.rimuovi();
        System.out.println("Pagamento completato. Cliente rimosso dalla coda.");
    }


    private static int leggiInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido.");
            }
        }
    }

    private static double leggiDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido.");
            }
        }
    }
}
