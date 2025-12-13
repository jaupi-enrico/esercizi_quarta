import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Coda {
    private Queue<Cliente> queue;

    public Coda() {
        queue = new LinkedList<>();
    }

    public void aggiungi(Cliente clt) {
        queue.add(clt);
    }

    public void rimuovi() {
        Cliente clt = queue.peek();
        if (clt == null) {
            return;
        }
        if (clt.getCodiceTessera() == null) {
            clt.setTessera("0000", 0);
        }
        clt.addPunti(clt.getCarrello().paga());
        queue.remove();
    }

    public ArrayList<Cliente> visualizzaClienti() {
        return new ArrayList<>(queue);
    }
}
