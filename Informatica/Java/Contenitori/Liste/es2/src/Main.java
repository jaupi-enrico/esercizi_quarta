import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedList<Integer> arr = new LinkedList<>();


        System.out.print("Inserisci N: ");
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            arr.add((int) (Math.random()*1000000));
        }
        for (Integer i : arr) {
            if ((int) Math.sqrt(i) * Math.sqrt(i) == i) {
                System.out.println(i);
            }
        }
    }
}