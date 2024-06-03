package edu.ufp.inf.projeto.JavaFXStuff;
import edu.ufp.inf.projeto.JavaFXStuff.Autor;

public interface gestaoAutor {
    /**
     * Adicionar autor
     * @param autor autor
     */
    void adicionarAutor(Autor autor);

    /**
     * Remover autor
     * @param orcid do Autor
     */
   void removerAutor(int orcid);

    /**
     * Buscar autor
     * @param orcid Autor
     * @return Orcid
     */
    Autor buscarAutor(int orcid);

    /**
     * Gravar Autor Removido
     * @param autor autor
     */
 void gravarAutorRemovido(Autor autor);

    /**
     * Remover Autor para Ficheiro
     * @param orcid do Autor
     */
 void removerAutorParaFicheiro(int orcid) ;
}
