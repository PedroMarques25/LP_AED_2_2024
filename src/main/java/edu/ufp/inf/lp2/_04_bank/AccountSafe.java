package edu.ufp.inf.lp2._04_bank;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountSafe extends Account implements AccountMoneyI,AccountOwnershipsI{


    public AccountSafe(String accountNumber, double balance, Client owner) {
        super(accountNumber, balance, owner);
    }

    @Override
    public double withdraw(double amount) throws OverWithdrawException {
        if(super.getBalance()>=amount){
            super.setBalance(super.getBalance()-amount);
            return super.getBalance();
        }else {
            throw new OverWithdrawException("Not enough money to withdraw!");
        }

//        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Not enough money to withdraw!!");
//        return super.getBalance()
    }

    @Override
    public double deposit(double amount) throws IllicitDepositException {
        if(amount>0){
            super.setBalance(super.getBalance()+amount);
            return super.getBalance();
        }else throw  new IllicitDepositException("Cannot deposit negative amounts!");
//        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Cannot deposit negative amounts");
//        return super.getBalance();
    }

    @Override
    public double transfer(AccountMoneyI destination, double amount) throws OverWithdrawException, IllicitDepositException{

//        double prevBalance= this.balance();
//        double b=this.withdraw(amount);

//        if(prevBalance>b){
//            destination.deposit(amount);
//        }

//        return super.getBalance();

        double balance = this.withdraw(amount);
        try{
            destination.deposit(amount);
        }catch (IllicitDepositException ide){
            this.setBalance(this.getBalance() + amount);
            throw new  IllicitDepositException("Cannot deposit negative amounts (previous withdraw was corrected)!\n");
        }
        return this.balance();
    }

    @Override
    public double balance() {
        return super.getBalance();
    }

    public static void main(String[] args) /*throws OverWithdrawException,IllicitDepositException*/ {
        AccountSafe a1 = new AccountSafe("1111",400,null);
        try {
            a1.withdraw(300.0);
            a1.deposit(100.0);
            double newbalance = a1.getBalance();
            System.out.println(newbalance);
        }catch (Exception e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.INFO, e.toString());
        }finally {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.INFO,"Try-catch finished!!");
        }

    }
}
