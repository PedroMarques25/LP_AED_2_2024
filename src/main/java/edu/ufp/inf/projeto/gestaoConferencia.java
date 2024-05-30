package edu.ufp.inf.projeto;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public interface gestaoConferencia {

    /**
     * Adiciona Conferencia
     * @param conferencia conferencia
     */
    void adicionarConferencia(Conferencia conferencia);

    /**
     * Remover Conferencia
     * @param nome da conferecia
     */
     void removerConferencia(String nome);

    /**
     * Buscar Conferencia
     * @param nome da conferencia
     * @return nome da conferencia
     */
    Conferencia buscarConferencia(String nome);

    /**
     * Remover Conferencia
     * @param nome da conferencia
     * @return Nome
     */
    Conferencia removerConferenciaParaFicheiro(String nome);

}

