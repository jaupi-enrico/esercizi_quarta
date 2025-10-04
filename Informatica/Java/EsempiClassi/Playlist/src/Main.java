import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int scelta = -2;
        Scanner in = new Scanner(System.in);
        Playlist p = null;
        Playlist pCopia = null;

        while (scelta != -1) {
            System.out.println("Inserisci la tua scelta:");
            System.out.println("1) Crea playlist");
            System.out.println("2) Play");
            System.out.println("3) Pause");
            System.out.println("4) Stop");
            System.out.println("5) Reset state");
            System.out.println("6) Numero brani");
            System.out.println("7) Nome playlist");
            System.out.println("8) Copia playlist");
            System.out.println("9) Stampa playlist");
            System.out.println("10) Brano successivo");
            System.out.println("11) Brano precedente");

            System.out.print("Insisci la tua scelta: ");
            scelta = in.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Nome: ");
                    String name = in.next();
                    System.out.print("Numero brani: ");
                    int n = in.nextInt();
                    p = new Playlist(name, n);
                case 2:
                    if (p != null) {
                        p.play();
                    }
                case 3:
                    if (p != null) {
                        p.pause();
                    }
                case 4:
                    if (p != null) {
                        p.stop();
                    }
                case 5:
                    if (p != null) {
                        p.stop();
                        p.stop();
                    }
                case 6:
                    if (p != null) {
                        System.out.println("Brani: " + p.getQuantiBrani());
                    }
                case 7:
                    if (p != null) {
                        System.out.println("Nome: " + p.getName());
                    }
                case 8:
                    if (p != null) {
                        pCopia = new Playlist(p);
                        System.out.println(p.toString());
                        System.out.println(pCopia.toString());
                    }
                case 9:
                    if (p != null) {
                        System.out.println(p.toString());
                    }
                case 10:
                    if (p != null) {
                        p.branoSuccessivo();
                    }
                case 11:
                    if (p != null) {
                        p.branoPrecedente();
                    }
            }
        }
    }
}