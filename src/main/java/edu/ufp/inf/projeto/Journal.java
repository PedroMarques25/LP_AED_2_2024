package edu.ufp.inf.projeto;


import java.util.ArrayList;
import java.util.List;

public class Journal extends Publicacao{
  private String publisher;
  private int periodicidade;
  private int JCR_IF;
  private int scopus_IF;

  // Lista estática de journals
  private static List<Journal> journals = new ArrayList<>();
  public Journal (String publisher, int periodicidade, int JCR_IF, int scopus_IF,String nome,String tipo) {
    super(nome,tipo);
    this.setPublisher(publisher);
    this.setPeriodicidade(periodicidade);
    this.setJCR_IF(JCR_IF);
    this.setScopus_IF(scopus_IF);
  }

  // Getters
  public String getPublisher() {
    return publisher;
  }

  public int getPeriodicidade() {
    return periodicidade;
  }

  public int getJCR_IF() {
    return JCR_IF;
  }

  public int getScopus_IF() {
    return scopus_IF;
  }

  // Setters
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public void setPeriodicidade(int periodicidade) {
    this.periodicidade = periodicidade;
  }

  public void setJCR_IF(int JCR_IF) {
    this.JCR_IF = JCR_IF;
  }

  public void setScopus_IF(int scopus_IF) {
    this.scopus_IF = scopus_IF;
  }

  // Métodos para adicionar, remover e atualizar journals
  public static Journal adicionarJournal(String publisher, int periodicidade, int JCR_IF, int scopus_IF,String nome,String tipo) {
    Journal journal = new Journal( publisher,  periodicidade,  JCR_IF, scopus_IF, nome, tipo);

    journals.add(journal);
    return journal;
  }

  public static void removerJournal(Journal journal) {
    journals.remove(journal);
  }

  public void atualizarJournal(String publisher, int periodicidade, int JCR_IF, int scopus_IF) {
    this.setPublisher(publisher);
    this.setPeriodicidade(periodicidade);
    this.setJCR_IF(JCR_IF);
    this.setScopus_IF(scopus_IF);
  }

  // Método para obter a lista de journals (opcional)
  public static List<Journal> getJournals() {
    return journals;
  }
}