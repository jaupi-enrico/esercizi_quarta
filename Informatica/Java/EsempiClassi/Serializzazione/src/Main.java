import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Library lib = new Library();

        lib.serialize("test.bin");

        Library lib2 = Library.deserialize("test.bin");

        System.out.println(lib2);
    }
}