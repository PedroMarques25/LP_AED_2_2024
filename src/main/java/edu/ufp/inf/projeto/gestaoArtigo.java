package edu.ufp.inf.projeto;

import org.w3c.dom.Node;

public interface gestaoArtigo {
  
  void addArtigo(Double key,String value);

void addArtigoNode(double key,String value);

void deleteArtigo(double key);
  
Node deleteArtigoNode(Node h, double key);
  
Iterable<Double> getArtigo();
  
}
