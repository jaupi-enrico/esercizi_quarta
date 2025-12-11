import java.io.*;
import java.util.ArrayList;

public class Library implements Serializable {
    private ArrayList<Book> arr;

    public Library() {
        arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(new Book());
        }
    }

    public ArrayList<Book> getArr() {
        return arr;
    }

    public void serialize(String src) throws IOException {
        try (FileOutputStream fi = new FileOutputStream(src);
             ObjectOutputStream os = new ObjectOutputStream(fi)) {
            os.writeObject(this);
        }
    }

    public static Library deserialize(String src) throws IOException, ClassNotFoundException {
        try (FileInputStream fi = new FileInputStream(src);
             ObjectInputStream oi = new ObjectInputStream(fi)) {

            return (Library) oi.readObject();
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "arr=" + arr +
                '}';
    }
}