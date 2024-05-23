package edu.ufp.inf.lp2._04_bank;


import edu.ufp.inf.lp2._01_intro.Date;
import edu.ufp.inf.lp2._01_intro.Person;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client extends Person implements ClientRelationshipsI {

    private final String vatNumber;
    private final ArrayList<Account> accounts=new ArrayList<>();

    public Client(String idNumber, String name, String address, Date birth, String vatNumber) {
        super(idNumber, name, address, birth);
        this.vatNumber = vatNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void addAccount(Account account) {
        for(Account a : this.accounts){
            if(a.getAccountNumber().compareTo(account.getAccountNumber())==0){
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Account already exists!!");
                return;
            }
        }
        this.accounts.add(account);
        account.setOwner(this);
    }

    @Override
    public Account getAccount(int index) {
        if(index>0 && index<this.accounts.size()){
            return this.accounts.get(index);
        }
        return null;
    }
}
