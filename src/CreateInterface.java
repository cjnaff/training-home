import org.junit.Test;

public class CreateInterface {
    public static void main(String[] args) {
        InterfaceTest t = new InterfaceTest(){};

        t.print();

    }
    @Test
    public void createInterfaceOutsideStaticMethod() {
        InterfaceTest t = new InterfaceTest(){};

        t.print();
        Runnable r = new Runnable() {

            @Override
            public void run() {

            }
        };
    }
}
