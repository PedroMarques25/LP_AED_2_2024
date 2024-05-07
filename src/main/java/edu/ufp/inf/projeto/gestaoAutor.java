package edu.ufp.inf.projeto;
import org.w3c.dom.Node;

public interface gestaoAutor {
  
void addAutor(Double key,String value);

void addAutorNode(double key,String value);

void deleteAutor(double key);
  
Node deleteAutorNode(Node h, double key);
  
Iterable<Double> getAutores();

}
