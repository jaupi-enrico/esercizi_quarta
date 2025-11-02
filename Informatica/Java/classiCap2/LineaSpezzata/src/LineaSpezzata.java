public class LineaSpezzata {
    private Punto[] vertici;
    private int nVertici;
    private boolean chiusa;
    private static final int MAX_VERTICI = 1000;

    public LineaSpezzata(Punto p1, Punto p2) {
        vertici = new Punto[MAX_VERTICI];
        vertici[0] = new Punto(p1);
        vertici[1] = new Punto(p2);
        nVertici = 2;
        chiusa = false;
    }

    public LineaSpezzata(Segmento s) {
        this(s.getA(), s.getB());
    }

    public void add(Punto p) {
        if (nVertici >= MAX_VERTICI) {
            System.out.println("Numero massimo di vertici raggiunto!");
            return;
        }
        if (chiusa) {
            System.out.println("Impossibile aggiungere punti a una spezzata chiusa!");
            return;
        }
        vertici[nVertici] = new Punto(p);
        nVertici++;
    }

    public void cambia() {
        chiusa = !chiusa;
    }

    public Punto getBaricentro() {
        double sommaX = 0;
        double sommaY = 0;

        for (int i = 0; i < nVertici; i++) {
            sommaX += vertici[i].getX();
            sommaY += vertici[i].getY();
        }

        return new Punto(sommaX / nVertici, sommaY / nVertici);
    }

    public void ruotaOrigine(double angolo) {
        for (int i = 0; i < nVertici; i++) {
            vertici[i] = ruotaPunto(vertici[i], new Punto(0, 0), angolo);
        }
    }

    public void ruotaBaricentro(double angolo) {
        Punto baricentro = getBaricentro();
        for (int i = 0; i < nVertici; i++) {
            vertici[i] = ruotaPunto(vertici[i], baricentro, angolo);
        }
    }

    private Punto ruotaPunto(Punto p, Punto centro, double angolo) {
        double rad = Math.toRadians(angolo);
        double xRel = p.getX() - centro.getX();
        double yRel = p.getY() - centro.getY();

        double xNew = xRel * Math.cos(rad) - yRel * Math.sin(rad);
        double yNew = xRel * Math.sin(rad) + yRel * Math.cos(rad);

        return new Punto(xNew + centro.getX(), yNew + centro.getY());
    }

    @Override
    public String toString() {
        String stato;
        if (chiusa) {
            stato = "chiusa";
        } else {
            stato = "aperta";
        };
        return "Spezzata composta da " + nVertici + " vertici.\nLa spezzata è " + stato + ".";
    }

    public int getNumeroVertici() {
        return nVertici;
    }

    public boolean isChiusa() {
        return chiusa;
    }

    public void stampaVertici() {
        System.out.println("Vertici della spezzata:");
        for (int i = 0; i < nVertici; i++) {
            System.out.println("  Vertice " + (i + 1) + ": " + vertici[i]);
        }
    }
}
