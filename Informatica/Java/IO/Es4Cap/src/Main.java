import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.next();
        String surname = in.next();
        String provider = in.next();

        String email1 = surname.concat("." + name + "@" + provider);
        System.out.println(email1);

        name = in.next();
        surname = in.next();
        provider = in.next();

        String email2 = surname.concat("." + name + "@" + provider);
        System.out.println(email2);

        if (email1.equals(email2)) {
            System.out.println("Le email sono identiche");
        } else {
            System.out.println("Le email sono diverse");
        }
    }
}