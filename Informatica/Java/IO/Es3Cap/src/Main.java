import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char lettera = str.charAt(str.length() - i - 1);

            str2= str2.concat("" + lettera);
        }
        System.out.println(str2);
    }
}