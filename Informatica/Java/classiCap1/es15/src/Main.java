import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Nome giocatore 1: ");
        String g1 = in.nextLine();
        System.out.print("Nome giocatore 2: ");
        String g2 = in.nextLine();
        System.out.print("Chi serve per primo (1 o 2): ");
        int inizio = in.nextInt();
        System.out.print("Partita al meglio di (3 o 5): ");
        int tipo = in.nextInt();

        TabelloneTennis t = new TabelloneTennis(g1, g2, inizio, tipo);

        int scelta = 0;
        while (scelta != 4) {
            System.out.println("\n1. Punto a " + g1);
            System.out.println("2. Punto a " + g2);
            System.out.println("3. Mostra tabellone");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            scelta = in.nextInt();

            if (scelta == 1)
                t.aggiungiPunto(1);
            else if (scelta == 2)
                t.aggiungiPunto(2);
            else if (scelta == 3)
                System.out.println("\n" + t.toString());

            if (!t.vittoria().equals("")) {
                System.out.println("\n Vittoria di " + t.vittoria() + "!");
                scelta = 4;
            }
        }
    }
}
