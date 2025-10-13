public class Segmento {
    private Punto p1;
    private Punto p2;

    public Segmento(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Segmento(Segmento s) {
        this.p1 = s.p1;
        this.p2 = s.p2;
    }

    public boolean interseca(Segmento s) {
        if ((this.p1.getX() == s.p1.getX() && this.p1.getY() == s.p1.getY()) && (this.p2.getX() == s.p2.getX() && this.p2.getY() == s.p2.getY())) {
            return true;
        }
        return false;
    }

    public void routaOrigine(double a) {
        this.p1.ruota(a);
        this.p2.ruota(a);
    }

    public void routaEstremo
}
