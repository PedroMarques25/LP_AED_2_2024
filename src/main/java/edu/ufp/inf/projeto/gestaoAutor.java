package edu.ufp.inf.projeto;
import org.w3c.dom.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public interface gestaoAutor {
    void adicionarAutor(Autor autor) ;
   void removerAutor(String orcid) ;
    Autor buscarAutor(String orcid) ;
 void gravarAutorRemovido(Autor autor) ;

 void removerAutorParaFicheiro(int orcid) ;
}
