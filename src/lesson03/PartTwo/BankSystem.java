package lesson03.PartTwo;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {

    private static Map<Integer, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        if (account != null) {
            accounts.put(account.accountNumber, account);
        }
    }

    public void deleteAccount(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
        }
    }

    public void replenishAccount(Account account, double amount) {
        account.balance += amount;
    }

    public void transferMoneyBetweenAccounts(Account accountOne, Account accountTwo, double amount) {
        if (accountOne.balance >= amount) {
            accountOne.balance -= amount;
            replenishAccount(accountTwo, amount);
        }
    }

    public class Account {
        private int accountNumber;
        private String foi;
        private double balance;

        public String getAccountInfo() {
            return "Account number - " + accountNumber + ", fio - " + foi + ", balance - " + balance;
        }
    }

}
