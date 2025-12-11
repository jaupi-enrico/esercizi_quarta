public class Main {
    public static void main(String[] args) {
        ContoCorrente c = new ContoCorrente("Mario", "Rossi", "1234");
        try {
            c.eseguiOperazione(new Operazione("deposito", 1000, 2));
            c.eseguiOperazione(new Operazione("prelievo", 26662, 1));
        }
        catch (ContoCorrente.OperazioneNotValidEException e) {
            System.out.println(e);
        }
        System.out.println(c);
    }
}