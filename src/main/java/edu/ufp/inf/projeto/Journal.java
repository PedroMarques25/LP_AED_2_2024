package edu.ufp.inf.projeto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journal extends LocalPublicacao {

  public String publisher;

  public int periodicidade;

  public int JCR_IF;
  public List<Artigo> artigosdejornal = new ArrayList<>();
  public int scopus_IF;
  public Journal(String publisher, int periodicidade,int JCR_IF,List<Artigo> artigosdejornal,int scopus_IF){
    this.publisher=publisher;
    this.periodicidade=periodicidade;
    this.JCR_IF=JCR_IF;
    this.artigosdejornal=artigosdejornal;
    this.scopus_IF=scopus_IF;
  }
  public List<Artigo> artigos;
  public List<Journal> jornais = new ArrayList<>();

  public void adicionarJournal( Journal jornal) {
    jornais.add(jornal);
  }

  public void removerJournal(  Journal jornal) {
    jornais.remove(jornal);
  }

  public void atualizarJournal( String publisher, int periodicidade, int JCR_IF, int scopus_IF,List<Artigo> artigosdejornal,int key) {
    jornais.get(key).publisher=publisher;
    jornais.get(key).periodicidade=periodicidade;
    jornais.get(key).JCR_IF=JCR_IF;
    jornais.get(key).scopus_IF=scopus_IF;
    jornais.get(key).artigosdejornal=artigosdejornal;
  }

}
