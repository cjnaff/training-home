interface InterfaceTest {
    public  default void print() {
        System.out.println("test");
    }
    static void method() {
        System.out.println("static");
    }
}
