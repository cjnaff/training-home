public class IdentifyMyParts {
    static void log(Object o)   { /* code */ }  // line n1
    static void log(Long[] lwa) { /* code */ }  // line n2
//    static void log(Integer[] iwa) { /* code */ }  // line n2

    public static int x = 7;
    public int y = 3;

    public static void main(String[] args) {
        log(new Integer[]{});
        long[] arr = null;
        log(arr);
        log(null);
    }
}