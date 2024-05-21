package edu.ufp.inf.projeto;

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

  // Lista estática de artigos
  public static List<Artigo> artigos = new ArrayList<>();

  public Artigo (String titulo, String palavrasChave, String abstractTexto, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia, int numLikespDia) {
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
  }
  // Getters
  public String getTitulo() {
    return titulo;
  }

  public String getPalavrasChave() {
    return palavrasChave;
  }

  public String getAbstractTexto() {
    return abstractTexto;
  }

  public String getTipoDePublicacao() {
    return tipoDePublicacao;
  }

  public int getAno() {
    return ano;
  }

  public int getNumDownloads() {
    return numDownloads;
  }

  public int getNumViewspDia() {
    return numViewspDia;
  }

  public int getNumLikespDia() {
    return numLikespDia;
  }

  // Setters
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setPalavrasChave(String palavrasChave) {
    this.palavrasChave = palavrasChave;
  }

  public void setAbstractTexto(String abstractTexto) {
    this.abstractTexto = abstractTexto;
  }

  public void setTipoDePublicacao(String tipoDePublicacao) {
    this.tipoDePublicacao = tipoDePublicacao;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public void setNumDownloads(int numDownloads) {
    this.numDownloads = numDownloads;
  }

  public void setNumViewspDia(int numViewspDia) {
    this.numViewspDia = numViewspDia;
  }

  public void setNumLikespDia(int numLikespDia) {
    this.numLikespDia = numLikespDia;
  }
  public List<Autor> getAutores() {
    return autores;
  }

  public void adicionarAutor(Autor autor) {
    autores.add(autor);
    autor.adicionarArtigo(this);
  }

  public void removerAutor(Autor autor) {
    autores.remove(autor);
    autor.removerArtigo(this);
  }

  public List<Artigo> getReferencias() {
    return referencias;
  }

  public void adicionarReferencia(Artigo artigo) {
    referencias.add(artigo);
  }

  public void removerReferencia(Artigo artigo) {
    referencias.remove(artigo);
  }

  // Métodos para adicionar, remover e atualizar artigos
  public static Artigo adicionarArtigo(String titulo, String palavrasChave, String abstractTexto, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia, int numLikespDia) {
    Artigo artigo = new Artigo(titulo, palavrasChave, abstractTexto, tipoDePublicacao,  ano,  numDownloads,  numViewspDia, numLikespDia);
    artigos.add(artigo);
    return artigo;
  }

  public static void removerArtigo(Artigo artigo) {
    artigos.remove(artigo);
  }

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

  // Método para obter a lista de artigos
  public static List<Artigo> getArtigos() {
    return artigos;
  }
}