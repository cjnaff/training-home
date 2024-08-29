import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class StringyStrings {

    public static void main(String[] args) {

        String s = new String(new StringBuilder().append(" "));
        System.out.println("s: '" + s + "'. blank:" + s.isBlank() + ", empty: " + s.isEmpty());
        System.out.println(s.compareTo("") );
        System.out.println(Boolean.valueOf(true || false));

        Deque d = new LinkedList();
    }


}
