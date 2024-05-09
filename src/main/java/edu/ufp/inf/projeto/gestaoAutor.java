package edu.ufp.inf.projeto;
import org.w3c.dom.Node;

public interface gestaoAutor {
    void addAutor(Double key, String value);

   //Node addAutorNode(Node node,Double key,String value);

   void deleteAutor(Double key);
  
   //Node deleteAutorNode(Node h, Double key);
  
   Iterable<Double> getAutores();

}
