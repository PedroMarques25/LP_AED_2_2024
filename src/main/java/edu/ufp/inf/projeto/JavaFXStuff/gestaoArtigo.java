package edu.ufp.inf.projeto.JavaFXStuff;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface gestaoArtigo {
    /**
     * Adicionar artigo
     * @param artigo
     */
     void adicionarArtigo(Artigo artigo);

    /**
     * Remover Artigo
     * @param titulo do artigo
     */
    void removerArtigo(String titulo) ;

    /**
     * Buscar Artigo
     * @param titulo do artigo
     * @return titulo do artigo
     */
     Artigo buscarArtigo(String titulo);

    /**
     * Buscar Artigos por autor e periodo
     * @param orcid do artigo
     * @param anoInicio do artigo
     * @param anoFim do artigo
     * @return resultado
     */
    public List<Artigo> buscarArtigosPorAutorEPeriodo(int orcid, int anoInicio, int anoFim) ;

    /**
     * Buscar Artigos
     * @param anoInicio do artigo
     * @param anoFim do artigo
     * @return artigo
     */
    public List<Artigo> buscarArtigos(int anoInicio, int anoFim) ;

    public List<Artigo> getTop3ArtigosMaisVisualizados() ;
  
}
