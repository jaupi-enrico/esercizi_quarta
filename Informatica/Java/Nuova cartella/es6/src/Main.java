public class Main {
    public static void main(String[] args) {
        try {
            Dado d = new Dado(1);
        } catch (Dado.ValueNonValidoException e) {
            System.out.println(e);
        }

    }
}