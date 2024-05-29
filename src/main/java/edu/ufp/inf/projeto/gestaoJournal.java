package edu.ufp.inf.projeto;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public interface gestaoJournal {
    void adicionarJournal(Journal journal);
     void removerJournal(String nome) ;
    public Journal buscarJournal(String nome);
    Journal removerJournalParaFicheiro(String JCR_IF);
}
