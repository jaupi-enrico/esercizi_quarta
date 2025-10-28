import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Azione {
    private String description;
    private LocalDateTime date;
    private int level;

    public Azione(String desc, int level) {
        this.description = desc;
        this.level = level;
        this.date = LocalDateTime.now();
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return "" + date;
    }

    private String toTextLevel(int level) {
        switch (level) {
            case 1:
                return "nessun problema";
            case 2:
                return "annotazione";
            case 3:
                return "evento moderato";
            case 4:
                return "evento grave";
            case 5:
                return "evento critico";
        }
        return "Error";
    }

    @Override
    public String toString() {
        String s = "Descrizione: ";
        s += getDescription() + "\n";
        s += getTime() + "\n";
        s += toTextLevel(level);
        return s;
    }
}
