package edu.ufp.inf.lp2._04_bank;

public class AccountOwnerNotDefinedException extends Exception {

    public AccountOwnerNotDefinedException() {
    }

    public AccountOwnerNotDefinedException(String message) {
        super(message);
    }

    public AccountOwnerNotDefinedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountOwnerNotDefinedException(Throwable cause) {
        super(cause);
    }

    public AccountOwnerNotDefinedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
