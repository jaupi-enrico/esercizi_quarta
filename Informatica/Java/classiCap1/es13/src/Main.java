public class Main {
    public static void main(String[] args) {
        OrologioDigitale orologio = new OrologioDigitale(23, 59);

        System.out.println(orologio);

        orologio.impostaOrario();
        orologio.aumenta();
        orologio.toggleOreMinuti();
        orologio.aumenta();


        orologio.impostaSveglia();
        orologio.diminuisci();
        orologio.toggleOreMinuti();
        orologio.diminuisci();
        orologio.toggleSveglia();

        System.out.println(orologio);
    }
}