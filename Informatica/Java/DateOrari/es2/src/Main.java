import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Giorno:");
        int g = in.nextInt();
        System.out.print("Mese:");
        int m = in.nextInt();
        System.out.print("Anno:");
        int y = in.nextInt();

        LocalDate day = LocalDate.of(y, m, g);
        System.out.println(day);
        System.out.println(day.plusDays(1));
        System.out.println(day.plusMonths(1));
        System.out.println(day.plusYears(1));
    }
}