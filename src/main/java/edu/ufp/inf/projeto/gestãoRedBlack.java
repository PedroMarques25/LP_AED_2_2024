package edu.ufp.inf.projeto;


import org.w3c.dom.Node;

public interface gestãoRedBlack {

void addDataRB(Double key,String value);

void addNode(double key,String value);
Node put(Node h, double key, String value);

void delete(double key);
Node delete(Node h, double key);
Iterable<Double> getKeysBST();

}
