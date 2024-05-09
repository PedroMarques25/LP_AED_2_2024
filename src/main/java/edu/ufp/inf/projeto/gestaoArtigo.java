package edu.ufp.inf.projeto;



public interface gestaoArtigo {

  void addArtigo(Double key,String value);

  //Node addArtigoNode(Node node,Double key,String value);

  void deleteArtigo(Double key);
  
  //Node deleteArtigoNode(Node h, Double key);
  
  Iterable<Double> getArtigo();
  
}
