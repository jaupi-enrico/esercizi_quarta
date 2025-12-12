import java.util.ArrayList;

public class Carrello {
    private ArrayList<Articolo> arr;

    public Carrello() {
        arr = new ArrayList<>();
    }

    public void aggiungiArticolo(Articolo art) {
        arr.add(art);
    }

    public void rimuoviArticolo(Articolo art) {
        arr.remove(art);
    }

    public void svuotaCarrello() {
        arr.clear();
    }

    public double calcolaTotaleCarrello() {
        double sum = 0;
        for (Articolo art : arr) {
            sum += art.getPrezzo();
        }
        return sum;
    }

    public long paga() {
        long punti = (long) calcolaTotaleCarrello() / 10;
        svuotaCarrello();
        return punti;
    }
}
