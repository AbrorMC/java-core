package lesson03;

public class BankAccount {
    private String fio;
    private int accountNumber;
    private double balance;

    public BankAccount(String foi, int accountNumber, double balance) {
        this.fio = foi;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double value) {
        balance += value;
    }

    public void withdraw(double value) {
        if (balance >= value) {
            balance -= value;
        } else {
            System.out.println("Not enough money");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getFoi() {
        return fio;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
