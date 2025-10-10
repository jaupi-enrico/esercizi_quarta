public class Main {
    public static void main(String[] args) {
        Punto p = new Punto(13.4, 3);
        Punto p2 = new Punto(p);
        p2.ruota(13);

        System.out.println(p.distanza(p2));
        System.out.println(p.pMedio(p2));
        System.out.println(p);
    }
}