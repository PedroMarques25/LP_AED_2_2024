package edu.ufp.inf.lp2._04_bank;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountUnsafe extends Account {

    public AccountUnsafe(String accountNumber, double balance, Client owner) {
        super(accountNumber, balance, owner);
    }

    @Override
    public double withdraw(double amount) {
        super.setBalance(super.getBalance() - amount);
        return super.getBalance();
    }

    @Override
    public double deposit(double amount) {
        super.setBalance(super.getBalance() + amount);
        return super.getBalance();
    }

    @Override
    public double transfer(AccountMoneyI destination, double amount) throws IllicitDepositException {
        double b = this.withdraw(amount);
        destination.deposit(amount);
        return b;
    }

    @Override
    public double balance() {
        return super.getBalance();
    }

    public static void main(String[] args) {
        AccountUnsafe a2 = new AccountUnsafe("2222", 0, null);
        try{
            a2.withdraw(300.0);
            a2.deposit(100.0);
            double newbalance = a2.getBalance();
            System.out.println(newbalance);
        } catch (Exception e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.INFO, e.toString());
        } finally {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.INFO, "Try-catch finished!!");
        }

    }

}
