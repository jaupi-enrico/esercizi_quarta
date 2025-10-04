public class GeneratoreAutoIncrementale {
    private String alpha;
    private long cifre;
    private long num;

    public GeneratoreAutoIncrementale(String alpha, long cifre) {
        this.alpha = alpha;
        this.cifre = cifre;
        this.num = 1;
    }

    public String genera() {
        long numberLen = 0;
        long i = num;
        while (i > 0) {
            i /= 10;
            numberLen++;
        }
        if (numberLen > cifre) {
            return "Codici Esauriti";
        }
        String space = "";
        for (int j = 0; j < cifre - numberLen && cifre - numberLen > 0; j++) {
            space += "0";
        }
        String out = alpha + space + num;
        num++;
        return out;
    }

    @Override
    public String toString() {
        return "Prefisso: " + alpha + " ultimo valore generato: " + (num - 1);
    }
}
