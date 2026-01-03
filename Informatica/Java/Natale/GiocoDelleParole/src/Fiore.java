import java.io.*;
import java.util.*;

public class Fiore {
    private ArrayList<String> stati; // ASCII art del fiore
    private int errori;

    public Fiore(String fileStati) {
        stati = new ArrayList<>();
        errori = 0;
        caricaStati(fileStati);
    }

    private void caricaStati(String fileStati) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileStati))) {
            String linea;
            StringBuilder sb = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().equals("---")) {
                    stati.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(linea).append("\n");
                }
            }
            if (!sb.isEmpty()) stati.add(sb.toString());
        } catch (IOException e) {
            System.out.println("Errore caricando file stati: " + e.getMessage());
        }
    }

    public void aumentaErrore() {
        if (errori < stati.size() - 1) errori++;
    }

    public void mostraFiore() {
        System.out.println(stati.get(errori));
    }

    public boolean haPerso() {
        return errori >= stati.size() - 1;
    }
}
