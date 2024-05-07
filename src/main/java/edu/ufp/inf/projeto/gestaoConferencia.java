package edu.ufp.inf.projeto;

public interface gestaoConferencia {

void addConferencia(Double key,String value);

void addConferenciaNode(double key,String value);

void deleteConferencia(double key);
  
Node deleteConferenciaNode(Node h, double key);
  
Iterable<Double> getConferencias();
  
}
