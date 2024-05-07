package edu.ufp.inf.projeto;

public interface gestãoSTI {

    void addKeyST(Double key,String value);

    String getKey(Double key);
    void removeKey(Double key);
    boolean containsKey(Double key);

    int getSize();
    Iterable<Double> getKeys();




}
