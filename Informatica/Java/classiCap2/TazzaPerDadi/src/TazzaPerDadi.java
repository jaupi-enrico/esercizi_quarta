import java.util.Arrays;

public class TazzaPerDadi {
    private Dado[] arr;
    private int nMax;
    private int n;

    TazzaPerDadi(int nMax) {
        arr = new Dado[nMax];
        this.nMax = nMax;
        this.n = 0;
    }

    TazzaPerDadi(int N, int F) {
        arr = new Dado[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Dado(F);
        }
        this.nMax = N;
        this.n = 0;
    }

    public boolean add(Dado d) {
        if (n < nMax) {
            arr[n] = new Dado(d);
            n++;
            return true;
        }
        return false;
    }

    public int quanti() {
        return this.n;
    }

    public int size() {
        return this.nMax;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int getMinimo() {
        return this.n;
    }

    public int getMassimo() {
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += arr[i].getFaccieDado();
        }
        return num;
    }

    public int lancia() {
        int num = 0;
        for (int i = 0; i < n; i++) {
            num += arr[i].lancia();
        }
        return num;
    }

    @Override
    public String toString() {
        String s = "Questa tazza può contenere al massimo " + nMax + " dadi" + "\n";
        s += "Dadi attualmente contenuti: " + n + "\n";
        s += "Lista dei dadi:\n";
        for (int i = 0; i < n; i++) {
            s += "- dado da " + arr[i].getFaccieDado() + "\n";
        }
        return s;
    }
}
