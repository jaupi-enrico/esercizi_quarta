import graphics.*;

public class Main {
    public static void main(String[] args) {
        InterfacciaSemaforo interfaccia = new InterfacciaSemaforo();

        interfaccia.accendiSemaforo();

        while (true) {
            try {
                Thread.sleep(7000);
                interfaccia.nextColor();
                Thread.sleep(2000);
                interfaccia.nextColor();
                Thread.sleep(7000);
                interfaccia.nextColor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
