public class Segmento {
    private Punto a;
    private Punto b;

    public Segmento(Punto a, Punto b) {
        this.a = new Punto(a);
        this.b = new Punto(b);
    }

    public Segmento(Segmento s) {
        this.a = new Punto(s.a);
        this.b = new Punto(s.b);
    }

    public Punto getA() {
        return a;
    }

    public Punto getB() {
        return b;
    }

    public double lunghezza() {
        return a.distanza(b);
    }

    public Punto puntoMedio() {
        return a.pMedio(b);
    }

    @Override
    public String toString() {
        return "Segmento [" + a + " - " + b + "]";
    }
}
