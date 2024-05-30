package edu.ufp.inf.projeto.JavaFXStuff;

import java.util.ArrayList;
import java.util.List;

public class Artigo {
  private String titulo;
  private String palavrasChave;
  private String abstractTexto;
  private String tipoDePublicacao;
  private List<Autor> autores;
  private List<Artigo> referencias;
  private int ano;
  private int numDownloads;
  private int numViewspDia;
  private int numLikespDia;
  private int ID;

  // Lista estática de artigos
  public static List<Artigo> artigos = new ArrayList<>();

  /**
   *
   * @param titulo do artigo
   * @param palavrasChave do artigo
   * @param abstractTexto do artigo
   * @param tipoDePublicacao do artigo
   * @param ano do lançamento do artigo
   * @param numDownloads pertencente ao artigo
   * @param numViewspDia pertencente ao artigo
   * @param numLikespDia pertencente ao artigo
   * @param ID do artigo
   */
  public Artigo(String titulo, String palavrasChave, String abstractTexto, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia, int numLikespDia,int ID) {
    this.setTitulo(titulo);
    this.setPalavrasChave(palavrasChave);
    this.setAbstractTexto(abstractTexto);
    this.setTipoDePublicacao(tipoDePublicacao);
    this.setAno(ano);
    this.setNumDownloads(numDownloads);
    this.setNumViewspDia(numViewspDia);
    this.setNumLikespDia(numLikespDia);
    this.autores = new ArrayList<>();
    this.referencias = new ArrayList<>();
    this.ID=ID;
  }

  /**
   * Getters
   */

  /**
   *
   *  @return titulo
   */
  public String getTitulo() {
    return titulo;
  }

  /**
   *
   * @return palavrasChave
   */
  public String getPalavrasChave() {
    return palavrasChave;
  }

  /**
   *
   * @return abstractTexto
   */
  public String getAbstractTexto() {
    return abstractTexto;
  }

  /**
   *
   * @return tipoDePublicacao
   */
  public String getTipoDePublicacao() {
    return tipoDePublicacao;
  }

  /**
   *
   * @return ano do artigo
   */
  public int getAno() {
    return ano;
  }

  /**
   *
   * @return numDownload do Artigo
   */
  public int getNumDownloads() {
    return numDownloads;
  }

  /**
   *
   * @return numViewspDia do Artigo
   */
  public int getNumViewspDia() {
    return numViewspDia;
  }

  /**
   *
   * @return numLikespDia
   */
  public int getNumLikespDia() {
    return numLikespDia;
  }

  /**
   *
   * @return ID do artigo
   */
  public int getID() {
    return ID;
  }

  /**
   * Setters
   */
  /**
   * Set do titulo do artigo
   * @param titulo do artigo
   */
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  /**
   * Set das palavrasChave do artigo
   * @param palavrasChave do artigo
   */
  public void setPalavrasChave(String palavrasChave) {
    this.palavrasChave = palavrasChave;
  }

  /**
   * Set do AbstractTexto do Artigo
   * @param abstractTexto do artigo
   */
  public void setAbstractTexto(String abstractTexto) {
    this.abstractTexto = abstractTexto;
  }

  /**
   * Set do tipoDePublicacao do Artigo
   * @param tipoDePublicacao do artigo
   */
  public void setTipoDePublicacao(String tipoDePublicacao) {
    this.tipoDePublicacao = tipoDePublicacao;
  }

  /**
   * Set ano do Artigo
   * @param ano do artigo
   */
  public void setAno(int ano) {
    this.ano = ano;
  }

  /**
   * Set Id do Artigo
   * @param id do artigo
   */
  public void setID(int id) {
    this.ID = id;
  }

  /**
   * Set numDownloads do Artigo
   * @param numDownloads do artigo
   */
  public void setNumDownloads(int numDownloads) {
    this.numDownloads = numDownloads;
  }

  /**
   * Set numViewspDia do Artigo
   * @param numViewspDia do artigo
   */
  public void setNumViewspDia(int numViewspDia) {
    this.numViewspDia = numViewspDia;
  }

  /**
   * Set numLikespDia do Artigo
   * @param numLikespDia do artigo
   */
  public void setNumLikespDia(int numLikespDia) {
    this.numLikespDia = numLikespDia;
  }

  /**
   * Método para obter a lista de Autores de artigos
   * @return autores
   */
  public List<Autor> getAutores() {
    return autores;
  }

  /**
   * Adicionar autor ao Artigo
   * @param autor do artigo
   */
  public void adicionarAutor(Autor autor) {
    autores.add(autor);
    autor.adicionarArtigo(this);
  }

  /**
   * Remover Autor do Artigo
   * @param autor do artigo
   */
  public void removerAutor(Autor autor) {
    autores.remove(autor);
    autor.removerArtigo(this);
  }

  /**
   * Método para obter a lista de referencias do artigo
   * @return referencias
   */
  public List<Artigo> getReferencias() {
    return referencias;
  }

  /**
   * Adicionar Referencias ao Artigo
   * @param artigo de artigo
   */
  public void adicionarReferencia(Artigo artigo) {
    referencias.add(artigo);
  }

  /**
   * Remover Referencias do Artigo
   * @param artigo de artigo
   */
  public void removerReferencia(Artigo artigo) {
    referencias.remove(artigo);
  }

  /**
   * Métodos para adicionar Artigo
   * @param titulo do artigo
   * @param palavrasChave do artigo
   * @param abstractTexto do artigo
   * @param tipoDePublicacao do artigo
   * @param ano do artigo
   * @param numDownloads do artigo
   * @param numViewspDia do artigo
   * @param numLikespDia do artigo
   * @param Id do artigo
   * @return artigo
   */
  public static Artigo adicionarArtigo(String titulo, String palavrasChave, String abstractTexto, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia, int numLikespDia,int Id) {
    Artigo artigo = new Artigo(titulo, palavrasChave, abstractTexto, tipoDePublicacao, ano, numDownloads, numViewspDia, numLikespDia,Id);
    artigos.add(artigo);
    return artigo;
  }

  /**
   * Metodo para Remover Artigo
   * @param artigo do artigo
   */
  public static void removerArtigo(Artigo artigo) {
    artigos.remove(artigo);
  }

  /**
   * Metodo para Atualizar o Artigo
   * @param titulo do artigo
   * @param palavrasChave do artigo
   * @param abstractTexto do artigo
   * @param tipoDePublicacao do artigo
   * @param ano do artigo
   * @param numDownloads do artigo
   * @param numViewspDia do artigo
   * @param numLikespDia do artigo
   */
  public void atualizarArtigo(String titulo, String palavrasChave, String abstractTexto, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia, int numLikespDia) {
    this.setTitulo(titulo);
    this.setPalavrasChave(palavrasChave);
    this.setAbstractTexto(abstractTexto);
    this.setTipoDePublicacao(tipoDePublicacao);
    this.setAno(ano);
    this.setNumDownloads(numDownloads);
    this.setNumViewspDia(numViewspDia);
    this.setNumLikespDia(numLikespDia);
  }

  /**
   * Método para obter a lista de artigos
   * @return artigos
   */
  public static List<Artigo> getArtigos() {
    return artigos;
  }

  /**
   * Metodo toString alterado para dar Print desejado
   * @return String
   */
  @Override
  public String toString() {
    return "Artigo{" +
            "titulo='" + titulo + '\'' +
            ", tipo_de_publicação='" + tipoDePublicacao + '\'' +
            '}';
  }
}
