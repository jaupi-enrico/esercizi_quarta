import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Canzone c1 = new Canzone("Suspicious Minds", 4, 22, "Elvis Presley");
        Canzone c2 = new Canzone("Hey Jude", 7, 11, "The Beatles");

        Playlist playlist = new Playlist("Rock anni 60", new Canzone[]{c1, c2});

        System.out.println("Benvenuto nella tua playlist!");
        String comando = "";

        while (true) {
            System.out.println("\nComandi disponibili: play, pause, stop, next, prev, add, show, durata, esci");
            System.out.print("Inserisci comando: ");
            comando = sc.nextLine().toLowerCase();

            switch (comando) {
                case "play":
                    playlist.play();
                    System.out.println("Play avviato!");
                    break;
                case "pause":
                    playlist.pause();
                    System.out.println("Pausa attivata!");
                    break;
                case "stop":
                    playlist.stop();
                    System.out.println("Stop!");
                    break;
                case "next":
                    playlist.branoSuccessivo();
                    System.out.println("Brano successivo!");
                    break;
                case "prev":
                    playlist.branoPrecedente();
                    System.out.println("Brano precedente!");
                    break;
                case "add":
                    System.out.print("Titolo: ");
                    String titolo = sc.nextLine();
                    System.out.print("Artista: ");
                    String artista = sc.nextLine();
                    System.out.print("Minuti: ");
                    int min = Integer.parseInt(sc.nextLine());
                    System.out.print("Secondi: ");
                    int sec = Integer.parseInt(sc.nextLine());
                    Canzone nuova = new Canzone(titolo, min, sec, artista);
                    if (playlist.add(nuova)) System.out.println("Canzone aggiunta!");
                    else System.out.println("Playlist piena, impossibile aggiungere!");
                    break;
                case "show":
                    System.out.println(playlist);
                    break;
                case "durata":
                    int[] tot = playlist.durataTotale();
                    System.out.println("Durata totale playlist: " + tot[0] + " minuti e " + tot[1] + " secondi");
                    break;
                case "esci":
                    System.out.println("Uscita dal programma.");
                    sc.close();
                    return;
                default:
                    System.out.println("Comando non riconosciuto!");
            }
        }
    }
}
