abstract class Account {
    private double balance;
    public abstract double interest() {
        return balance * 0.05;
    }
    public abstract void close();
}
class FixedDeposit extends Account {
    public double interest() { return 0.0; }
}
