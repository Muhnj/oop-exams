abstract class Account {
    private double balance;
    public abstract void close();
}
public class Test {
    public static void main(String[] args) {
        Account acc = new Account();
    }
}
