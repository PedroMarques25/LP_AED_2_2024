package edu.ufp.inf.lp2._04_bank;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Account implements AccountMoneyI, AccountOwnershipsI {

    private final String accountNumber; //Generate ONLY getAccountNumber()
    private double balance;             //Generate getBalance()/setBalance(b) OR
    //protected double balance;         //use protected field instead
    private Client owner;               //Use methods from AccountRelationshipsI

    public Account(String accountNumber, double balance, Client owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;

        if (owner != null) {
            owner.addAccount(this);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected Client getOwner() {
        return owner;
    }

    protected void setOwner(Client owner) {
        this.owner = owner;
    }

    public Client getAccountOwner() throws AccountOwnerNotDefinedException {
        if (this.owner != null) {
            return this.getOwner();
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Owner not defined yet!!");
        return null;
    }

    public void setAccountOwner(Client owner) {
        if (this.owner == null) {
            this.setOwner(owner);
            this.owner.addAccount(this);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0 && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(owner, account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, balance, owner);
    }
    @Override
    public double balance(){
        return balance;
    }
    @Override
    public abstract double withdraw(double amount) throws OverWithdrawException;
}
