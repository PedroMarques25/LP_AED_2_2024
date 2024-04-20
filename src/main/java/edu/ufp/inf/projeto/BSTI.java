package edu.ufp.inf.lp2.projeto;

import java.awt.*;

public interface BSTI {

    public void put(Key key, Value val);

    private Node put(Node x, Key key, Value val);

    public Value get(Key key);

    public void delete(Key key);

    private boolean isRed(Node x);

    private Node rotateLeft(Node h);

    private Node rotateRight(Node h);

    private void flipColors(Node h);

    private Node delete(Node x, Key key);
}