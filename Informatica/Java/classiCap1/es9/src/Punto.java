public class Punto {
    private double x;
    private double y;

    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punto(Punto p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double distanza(Punto p) {
        double d;

        d = Math.sqrt((this.x - p.x)*(this.x - p.x) + (this.y - p.y)*(this.y - p.y));

        return d;
    }

    public Punto pMedio(Punto p) {
        Punto medio = new Punto();

        medio.x = (this.x + p.x) / 2;
        medio.y = (this.y + p.y) / 2;

        return medio;
    }

    public void ruota(double angolo) {
        double rad = Math.toRadians(angolo);

        this.x = this.x * Math.cos(rad) - this.y * Math.sin(rad);
        this.y = this.x * Math.sin(rad) + this.y * Math.cos(rad);
    }

    @Override
    public String toString() {
        return "Il punto si trova in (" + this.x + "; " + this.y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
