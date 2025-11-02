public class Main {
    public static void main(String[] args) {
        ContoCorrente cc = new ContoCorrente("Mario", "Rossi", "ABC123");

        cc.eseguiOperazione(new Operazione("Versamento iniziale", 1500, 2));
        cc.eseguiOperazione(new Operazione("Pagamento affitto", 800, 1));
        cc.eseguiOperazione(new Operazione("Tentato prelievo eccessivo", 5000, 1));
        cc.eseguiOperazione(new Operazione("Stipendio", 2000, 2));

        System.out.println(cc);
        System.out.println("\n=== Operazioni Importanti ===");
        for (Operazione o : cc.getOperazioniImportanti()) {
            System.out.println(o);
        }

        System.out.println("\n=== Operazioni Non Eseguite ===");
        for (Operazione o : cc.getOperazioniNonEseguite()) {
            System.out.println(o);
        }

        System.out.println("\nSaldo finale: " + cc.getSaldo() + " €");
    }
}