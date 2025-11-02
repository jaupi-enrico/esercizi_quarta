public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(3, 0);
        Punto p3 = new Punto(3, 4);

        LineaSpezzata spezzata = new LineaSpezzata(p1, p2);
        System.out.println(spezzata);

        spezzata.add(p3);
        System.out.println("\nDopo aggiunta di un vertice:");
        System.out.println(spezzata);

        Punto bar = spezzata.getBaricentro();
        System.out.println("\nBaricentro: " + bar);

        spezzata.cambia();
        System.out.println("\nDopo cambio stato:");
        System.out.println(spezzata);

        spezzata.ruotaBaricentro(90);
        System.out.println("\nDopo rotazione di 90° intorno al baricentro:");
        spezzata.stampaVertici();
    }
}