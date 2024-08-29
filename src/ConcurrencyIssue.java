public class ConcurrencyIssue {
    private int regularInt = 5;

    public int addAndGet(int value) {
        regularInt += value;
        System.out.println("addAndGet " + regularInt);
        return regularInt;
    }

    public int getAndAdd(int value) {
        int temp = regularInt;
        regularInt += value;
        System.out.println("getAndAdd regularInt - " + regularInt + " and temp - " + temp);
        return temp;
    }

    public int get() {
        return regularInt;
    }

    public static void main(String[] args) {
        ConcurrencyIssue example = new ConcurrencyIssue();

        new Thread(() -> System.out.println(example.addAndGet(10))).start();
        new Thread(() -> System.out.println(example.getAndAdd(5))).start();

        try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("Main get " + example.get());
    }
}