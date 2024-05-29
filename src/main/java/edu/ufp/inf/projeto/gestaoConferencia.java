package edu.ufp.inf.projeto;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public interface gestaoConferencia {

    void adicionarConferencia(Conferencia conferencia);
     void removerConferencia(String nome);
    Conferencia buscarConferencia(String nome);
    Conferencia removerConferenciaParaFicheiro(String nome);

}

