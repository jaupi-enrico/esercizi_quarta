import graphics.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InterfacciaSemaforo interfaccia = new InterfacciaSemaforo();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=========================");
            System.out.println("       MENU SEMAFORO     ");
            System.out.println("=========================");
            System.out.println("1. Accendi semaforo");
            System.out.println("2. Cambia colore (next)");
            System.out.println("3. Spegni semaforo");
            System.out.println("4. Toggle (accendi/spegni)");
            System.out.println("5. Elimina semaforo (chiudi finestra)");
            System.out.println("6. Modalità automatica");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");

            int scelta = -1;
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    interfaccia.accendiSemaforo();
                    System.out.println("Semaforo acceso.");
                    break;
                case 2:
                    interfaccia.nextColor();
                    System.out.println("Colore cambiato.");
                    break;
                case 3:
                    interfaccia.spegniSemaforo();
                    System.out.println("Semaforo spento.");
                    break;
                case 4:
                    interfaccia.toggleSemaforo();
                    System.out.println("Toggle eseguito.");
                    break;
                case 5:
                    interfaccia.eliminaSemaforo();
                    System.out.println("Finestra chiusa.");
                    break;
                case 6:
                    System.out.println("Modalità automatica (premi INVIO per interrompere)");
                    Thread autoThread = new Thread(() -> {
                        try {
                            interfaccia.accendiSemaforo();
                            while (true) {
                                Thread.sleep(7000);
                                interfaccia.nextColor();
                                Thread.sleep(2000);
                                interfaccia.nextColor();
                                Thread.sleep(7000);
                                interfaccia.nextColor();
                            }
                        } catch (InterruptedException e) {
                            System.out.println("Modalità automatica interrotta.");
                            Canvas.close();
                        }
                    });
                    autoThread.start();

                    scanner.nextLine();
                    scanner.nextLine();
                    autoThread.interrupt();
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    interfaccia.eliminaSemaforo();
                    running = false;
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        }

        scanner.close();
    }
}