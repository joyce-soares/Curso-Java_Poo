package entities;

public class Account {
    private int number;
    private String holder;
    private double balance;

    public Account() {
    }

    public Account(int number, String holder, double initialDeposit) {
        this.number = number;
        this.holder = holder;
        depositValue(initialDeposit);
    }

    public Account(int number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getNumber() {
        return number;
    }

    public void depositValue(double deposit){
        balance += deposit;
    }

    public void withdrawValue(double withdraw){
        balance -= withdraw + 5.00;
    }

    public String toString() {
        return "Account " + number +
                ", Holder: " + holder +
                ", Balance: $ " + String.format("%.2f", balance);
    }
}
