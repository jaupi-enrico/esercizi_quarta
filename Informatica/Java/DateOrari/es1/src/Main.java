import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.plusDays(1));
        System.out.println(today.plusMonths(1));
        System.out.println(today.plusYears(1));
    }
}