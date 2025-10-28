public class Main {
    public static void main(String[] args) {
        Logger log = new Logger(5);

        System.out.println("Logger vuoto? " + log.isEmpty()); // true

        // --- Aggiungiamo alcune azioni ---
        log.add(new Azione("Accesso dall'IP 134.67.12.54", 2));
        log.add(new Azione("Modifica del file di configurazione http.conf", 4));
        log.add(new Azione("Montaggio del volume sda3", 1));
        log.add(new Azione("Tentativo di accesso non autorizzato", 5));

        System.out.println("\nLogger vuoto? " + log.isEmpty()); // false
        System.out.println("Totale azioni: " + log.size());    // 4

        // --- Test get ---
        System.out.println("\nAzione con indice 1:");
        System.out.println(log.get(1));  // stampa la seconda azione

        // --- Test getByAttenzione ---
        System.out.println("\nAzioni con livello 4:");
        for (Azione a : log.getByAttenzione(4)) {
            System.out.println(a);
        }

        // --- Test toString() finale ---
        System.out.println("\n========================");
        System.out.println(log);
    }
}
