package edu.ufp.inf.projeto;
import org.w3c.dom.Node;

public interface gestaoAutor {
  
void addAutor(Double key,String value);

Node addAutorNode(Node node,double key,String value);

void deleteAutor(double key);
  
Node deleteAutorNode(Node h, double key);
  
Iterable<Double> getAutores();

}
