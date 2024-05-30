package edu.ufp.inf.projeto;

import java.util.ArrayList;
import java.util.List;


public class Journal extends Publicacao {
  private String publisher;
  private int periodicidade;
  private int JCR_IF;
  private int scopus_IF;
  private List<Artigo> artigos;

  // Lista estática de journals
  private static List<Journal> journals = new ArrayList<>();

  /**
   * Constructor do Journal
   * @param publisher do journal
   * @param periodicidade do journal
   * @param JCR_IF do journal
   * @param scopus_IF do journal
   * @param nome do journal
   * @param tipo do journal
   */
  public Journal (String publisher, int periodicidade, int JCR_IF, int scopus_IF,String nome,String tipo) {
    super(nome,tipo);
    this.setPublisher(publisher);
    this.setPeriodicidade(periodicidade);
    this.setJCR_IF(JCR_IF);
    this.setScopus_IF(scopus_IF);
    this.artigos = new ArrayList<>();
  }

  // Getters

  /**
   * Get Publisher do Journal
   * @return publisher
   */
  public String getPublisher() {
    return publisher;
  }

  /**
   * Get Periodicidade do Journal
   * @return periodicidade
   */
  public int getPeriodicidade() {
    return periodicidade;
  }

  /**
   * get JCR_IF do Journal
   * @return JCR_IF
   */
  public int getJCR_IF() {
    return JCR_IF;
  }

  /**
   * Get Scopus_IF do Journal
   * @return scopus_IF
   */
  public int getScopus_IF() {
    return scopus_IF;
  }

  // Setters

  /**
   * Set Publisher do Journal
   * @param publisher do Journal
   */
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  /**
   * Set Periodicidade do Journal
   * @param periodicidade do Journal
   */
  public void setPeriodicidade(int periodicidade) {
    this.periodicidade = periodicidade;
  }

  /**
   * Set JCR_IF do Journal
   * @param JCR_IF do Journal
   */
  public void setJCR_IF(int JCR_IF) {
    this.JCR_IF = JCR_IF;
  }

  /**
   * Set Scopus_IF do Journal
   * @param scopus_IF do Journal
   */
  public void setScopus_IF(int scopus_IF) {
    this.scopus_IF = scopus_IF;
  }

  /**
   * Get Artigos do Journal
   * @return artigos
   */
  public List<Artigo> getArtigos() {
    return artigos;
  }

  /**
   * Adicionar Artigo
   * @param artigo artigo
   */
  public void adicionarArtigo(Artigo artigo) {
    artigos.add(artigo);
  }

  /**
   * Remover artigo
   * @param artigo artigo
   */
  public void removerArtigo(Artigo artigo) {
    artigos.remove(artigo);
  }

  /**
   *  Métodos para adicionar Journal
   * @param publisher do journal
   * @param periodicidade do journal
   * @param JCR_IF do journal
   * @param scopus_IF do journal
   * @param nome do journal
   * @param tipo do journal
   * @return journal
   */
  public static Journal adicionarJournal(String publisher, int periodicidade, int JCR_IF, int scopus_IF,String nome,String tipo) {
    Journal journal = new Journal( publisher,  periodicidade,  JCR_IF, scopus_IF, nome, tipo);

    journals.add(journal);
    return journal;
  }

  /**
   * Remover Journal
   * @param journal journal
   */
  public static void removerJournal(Journal journal) {
    journals.remove(journal);
  }

  /**
   * Atualizar journals
   * @param publisher do journals
   * @param periodicidade do journals
   * @param JCR_IF do journals
   * @param scopus_IF do journals
   */
  public void atualizarJournal(String publisher, int periodicidade, int JCR_IF, int scopus_IF) {
    this.setPublisher(publisher);
    this.setPeriodicidade(periodicidade);
    this.setJCR_IF(JCR_IF);
    this.setScopus_IF(scopus_IF);
  }

  /**
   * Método para obter a lista de journals (opcional)
   * @return journals
   */
  public static List<Journal> getJournals() {
    return journals;
  }

  @Override
  public String toString() {
    return "Journal{" +
            "Publisher='" + publisher + '\'' +
            ", SCOPUS_ID='" + scopus_IF + '\'' +
            '}';
  }
}
