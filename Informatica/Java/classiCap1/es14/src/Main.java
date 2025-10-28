public class Main {
    public static void main(String[] args) {
        TabellonePallavolo tabellone = new TabellonePallavolo("Brescia", "Como", 2);
        for (int i = 0; i < 55; i++) {
            tabellone.puntoCasa();
            tabellone.puntoOspiti();
        }
        System.out.println(tabellone);
    }
}