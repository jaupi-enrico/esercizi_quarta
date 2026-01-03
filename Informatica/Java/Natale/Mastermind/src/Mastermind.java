import java.util.ArrayList;

public class Mastermind {
    private Sequenza segreta;
    private ArrayList<Sequenza> tentativi;
    private ArrayList<Indizio> indizi;
    private int maxTentativi;

    public Mastermind() {
        this(new Sequenza(), 10);
    }

    public Mastermind(Sequenza segreta) {
        this(segreta, 10);
    }

    public Mastermind(Sequenza segreta, int maxTentativi) {
        if (maxTentativi < 5) maxTentativi = 10;
        this.segreta = segreta;
        this.maxTentativi = maxTentativi;
        tentativi = new ArrayList<>();
        indizi = new ArrayList<>();
    }

    public void add(Sequenza s) {
        if (tentativi.size() < maxTentativi) {
            tentativi.add(s);
            indizi.add(segreta.confronta(s));
        }
    }

    public boolean vittoria() {
        if (tentativi.isEmpty()) return false;
        return tentativi.get(tentativi.size() - 1).equals(segreta);
    }

    public boolean terminato() {
        return tentativi.size() >= maxTentativi && !vittoria();
    }

    public Sequenza getSequenza(int i) {
        if (i < 0 || i >= tentativi.size()) return null;
        return tentativi.get(i);
    }

    public Indizio getIndizio(int i) {
        if (i < 0 || i >= indizi.size()) return null;
        return indizi.get(i);
    }

    public Sequenza getSequenzaNascosta() {
        return segreta;
    }

    public int getTentativiEffettuati() {
        return tentativi.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mastermind, ")
                .append(tentativi.size())
                .append(" tentativi effettuati\n");

        for (int i = tentativi.size() - 1; i >= 0; i--) {
            sb.append(i + 1).append(" ")
                    .append(indizi.get(i)).append(" ")
                    .append(tentativi.get(i)).append("\n");
        }
        return sb.toString();
    }
}
