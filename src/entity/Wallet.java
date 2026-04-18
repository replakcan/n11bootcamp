package entity;

public class Wallet {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Wallet(double startingBalance) {
        this.balance = startingBalance;
    }
}
