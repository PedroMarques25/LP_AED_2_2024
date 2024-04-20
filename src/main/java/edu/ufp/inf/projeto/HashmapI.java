package edu.ufp.inf.lp2.projeto;

import java.awt.*;

public interface Hashmap {
    private int hash(K key);

    public void put(K key, V value);

    public V get(K key);

    public void remove(K key);

    private void resize();
}