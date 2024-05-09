package edu.ufp.inf.projeto;

import org.w3c.dom.Node;

public interface gestaoConferencia {

void addConferencia(Double key,String value);

Node addConferenciaNode(Node node, double key,String value);

void deleteConferencia(double key);
  
Node deleteConferenciaNode(Node h, double key);
  
Iterable<Double> getConferencias();
  
}
