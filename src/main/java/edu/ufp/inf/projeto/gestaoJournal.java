package edu.ufp.inf.projeto;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public interface gestaoJournal {
    /**
     * Adicionar Journal
     * @param journal ao journal
     */
    void adicionarJournal(Journal journal);

    /**
     * Remover Journal
     * @param nome do Journal
     */
     void removerJournal(String nome);

    /**
     * Buscar Journal
     * @param nome do Journal
     * @return Journal
     */
    public Journal buscarJournal(String nome);

    /**
     * Remover Journal para Ficheiro
     * @param JCR_IF do Journal
     * @return JCR_IF do Journal
     */
    Journal removerJournalParaFicheiro(String JCR_IF);
}
