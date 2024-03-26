package edu.ufp.inf.lp2._04_bank;

public class OverWithdrawException extends Exception {

    public OverWithdrawException() {
    }

    public OverWithdrawException(String message) {
        super(message);
    }

    public OverWithdrawException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverWithdrawException(Throwable cause) {
        super(cause);
    }

    public OverWithdrawException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }



}
