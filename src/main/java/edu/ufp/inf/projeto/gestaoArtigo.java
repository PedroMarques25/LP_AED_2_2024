package edu.ufp.inf.projeto;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface gestaoArtigo {
     void adicionarArtigo(Artigo artigo) ;
    void removerArtigo(String titulo) ;

     Artigo buscarArtigo(String titulo) ;
    public List<Artigo> buscarArtigosPorAutorEPeriodo(String orcid, int anoInicio, int anoFim) ;

    public List<Artigo> buscarArtigos(int anoInicio, int anoFim) ;
    public List<Artigo> getTop3ArtigosMaisVisualizados() ;
  
}
