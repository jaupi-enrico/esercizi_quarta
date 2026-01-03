import java.util.ArrayList;
import java.util.Random;

public class Colore {

    public static final int BIANCO = 0;
    public static final int NERO = 1;
    public static final int VERDE = 2;
    public static final int GIALLO = 3;
    public static final int ROSSO = 4;
    public static final int ARANCIONE = 5;

    public static final int NUM_COLORI = 6;

    private static ArrayList<String> sigle = new ArrayList<>();
    private static Random rand = new Random();

    static {
        sigle.add("B");
        sigle.add("N");
        sigle.add("V");
        sigle.add("G");
        sigle.add("R");
        sigle.add("A");
    }

    public static int casuale() {
        return rand.nextInt(NUM_COLORI);
    }

    public static String toString(int colore) {
        if (colore < 0 || colore >= NUM_COLORI) return "?";
        return sigle.get(colore);
    }
}
