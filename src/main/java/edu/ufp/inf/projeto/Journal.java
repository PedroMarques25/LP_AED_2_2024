package edu.ufp.inf.projeto;


import java.util.ArrayList;
import java.util.List;

public class Journal extends LocalPublicacao {

  public String publisher;

  public int periodicidade;

  public int JCR_IF;

  public int scopus_IF;
  public List<Artigo> artigos;
  public List<Journal> jornais = new ArrayList<>();

  public void adicionarJournal( String publisher, int periodicidade, int JCR_IF, int scopus_IF) {
  }

  public void removerJournal( String publisher, int periodicidade, int JCR_IF, int scopus_IF) {
  }

  public void atualizarJournal( String publisher, int periodicidade, int JCR_IF, int scopus_IF) {
  }

}
