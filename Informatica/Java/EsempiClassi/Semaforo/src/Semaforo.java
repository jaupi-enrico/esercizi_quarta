public class Semaforo {
    private boolean acceso;
    private String colore;

    public Semaforo()  {
        this.acceso = false;
        this.colore = "VERDE";
    }

    public void accendi() {
        acceso = true;
    }

    public void spegni() {
        acceso = false;
    }

    public void toggle() {
        acceso = !acceso;
    }

    public void avanza() {
        if (colore.equals("VERDE")) {
            colore = "GIALLO";
        } else if (colore.equals("GIALLO")) {
            colore = "ROSSO";
        }
        else {
            colore = "VERDE";
        }
    }

    public boolean isAcceso() {
        return acceso;
    }

    public String getColore() {
        return colore;
    }

    @Override
    public String toString() {
        if (acceso) {
            return "Il semaforo e' acceso sul " + colore;
        }
        else {
            return "Il semaforo e' spento";

        }
    }
}
