package edu.ufp.inf.lp2._04_bank;

public interface AccountMoneyI {
    double withdraw(double amount) throws OverWithdrawException;
    double deposit(double amount) throws IllicitDepositException;
    double transfer(AccountMoneyI destination, double amount) throws OverWithdrawException, IllicitDepositException;
    double balance();

}
