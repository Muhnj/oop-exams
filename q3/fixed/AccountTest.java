abstract class Account {
    private double balance;

    public double interest() {
        return balance * 0.05;
    }

    public abstract void close();
}

class FixedDeposit extends Account {
    @Override
    public double interest() { return 0.0; }

    @Override
    public void close() {
        System.out.println("Fixed deposit account closed");
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acc = new FixedDeposit();          // Way 1
        System.out.println("Interest: " + acc.interest());
        acc.close();

        Account acc2 = new Account() {             // Way 2
            @Override
            public void close() {
                System.out.println("Account closed");
            }
        };
        acc2.close();
    }
}
