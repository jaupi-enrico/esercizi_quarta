import java.time.LocalDateTime;

public class Logger {
    private Azione[] actions;
    private int nMax;
    private int n;
    private LocalDateTime firstActionTime;
    private LocalDateTime lastActionTime;

    public Logger(int nMax) {
        actions = new Azione[nMax];
        this.nMax = nMax;
        this.n = 0;
        this.firstActionTime = null;
        this.lastActionTime = null;
    }

    public void add(Azione a) {
        if (n >= nMax) return;

        actions[n] = a;
        if (n == 0)
            firstActionTime = LocalDateTime.now();
        lastActionTime = LocalDateTime.now();
        n++;
    }

    public Azione get(int i) {
        if (i < 0 || i >= n) return null;
        return actions[i];
    }

    public Azione[] getByAttenzione(int a) {
        if (a < 1 || a > 5) return new Azione[0];

        int count = 0;
        for (int i = 0; i < n; i++)
            if (actions[i].getLevel() == a) count++;

        Azione[] result = new Azione[count];
        int j = 0;
        for (int i = 0; i < n; i++)
            if (actions[i].getLevel() == a)
                result[j++] = actions[i];

        return result;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public String toString() {
        String s = "Numero totale di azioni: " + n + "\n";

        for (int i = 1; i <= 5; i++)
            s += "Livello " + i + " : " + getByAttenzione(i).length + " azioni\n";

        if (n > 0) {
            s += "Le azioni sono state memorizzate a partire dalle ore "
                    + firstActionTime + " UTC\n"
                    + "fino alle ore " + lastActionTime + " UTC";
        } else {
            s += "Nessuna azione registrata.";
        }

        return s;
    }
}
