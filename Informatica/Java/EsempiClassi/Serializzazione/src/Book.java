import java.io.*;

public class Book implements Serializable {
    private int pages;
    private String name;

    public Book() {
        name = "Test";
        pages = 10;
    }
}
