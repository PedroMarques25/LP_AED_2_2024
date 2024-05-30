package edu.ufp.inf.projeto;
import org.w3c.dom.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
   void removerAutor(String orcid);

    /**
     * Buscar autor
     * @param orcid Autor
     * @return Orcid
     */
    Autor buscarAutor(String orcid);

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
