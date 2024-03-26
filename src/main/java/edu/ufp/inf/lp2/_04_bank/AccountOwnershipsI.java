package edu.ufp.inf.lp2._04_bank;

public interface AccountOwnershipsI {

    Client getAccountOwner() throws AccountOwnerNotDefinedException;
    void setAccountOwner(Client owner);

}
