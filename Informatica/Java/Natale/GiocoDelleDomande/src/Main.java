import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Categoria> categorie = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        categorie.add(new Categoria("Cultura", "dati/cultura.txt"));
        categorie.add(new Categoria("Sport", "dati/sport.txt"));
        categorie.add(new Categoria("Storia", "dati/storia.txt"));

        System.out.print("Caricare la partita precedente (S/N)? ");
        String caricare = sc.nextLine();
        Partita partita = null;
        if (caricare.equals("S")) {
            partita = caricaPartita();
        }
        if (partita == null) {
            System.out.print("Nome giocatore: ");
            partita = new Partita(sc.nextLine());
        }

        Random rnd = new Random();

        while (true) {
            Categoria c1 = categorie.get(rnd.nextInt(categorie.size()));
            Categoria c2 = categorie.get(rnd.nextInt(categorie.size()));
            while (c1 == c2) {
                c2 = categorie.get(rnd.nextInt(categorie.size()));
            }

            System.out.println("1) " + c1.getNome());
            System.out.println("2) " + c2.getNome());
            System.out.print("Scegli categoria (0 per uscire): ");

            int scelta = sc.nextInt();
            if (scelta == 0) {
                salvaPartita(partita);
                break;
            }

            Categoria sceltaCat = (scelta == 1) ? c1 : c2;
            Domanda d = sceltaCat.domandaCasuale();

            d.stampa();
            int risposta = sc.nextInt();

            if (d.verifica(risposta)) {
                partita.punteggio++;
                System.out.println("✔ Corretto!");
            } else {
                System.out.println("✘ Sbagliato!");
                salvaRisultato(partita);
                break;
            }
        }

        System.out.println("Risposte corrette: " + partita.punteggio);
    }

    static void salvaPartita(Partita p) throws Exception {
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("salvataggi/partita.dat"));
        oos.writeObject(p);
    }

    static Partita caricaPartita() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("salvataggi/partita.dat"));
            return (Partita) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }

    static void salvaRisultato(Partita p) throws Exception {
        FileWriter fw = new FileWriter("salvataggi/classifica.txt", true);
        fw.write(p.giocatore + ";" + p.punteggio + ";" + new Date() + "\n");
        fw.close();
    }
}