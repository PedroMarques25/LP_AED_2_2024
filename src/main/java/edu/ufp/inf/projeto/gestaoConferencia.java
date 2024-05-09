package edu.ufp.inf.projeto;



public interface gestaoConferencia {

void addConferencia(Double key,String value);

//Node addConferenciaNode(Node node, Double key,String value);

void deleteConferencia(Double key);
  
//Node deleteConferenciaNode(Node h, Double key);
  
Iterable<Double> getConferencias();
  
}

