import java.util.List;

// Generic Class of Things
public class MyGenericThings<T> {
    List<T> things;

    public MyGenericThings(List<T> things) {
        this.things = things;
        logThings();
    }

    private void logThings() {
    }

    public List<T> getThings() {  return things; }
    public void setThings(List<T> things) { this.things = things;}
}
