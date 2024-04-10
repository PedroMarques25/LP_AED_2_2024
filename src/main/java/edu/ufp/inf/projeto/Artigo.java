package edu.ufp.inf.projeto;

import java.util.List;


public class Artigo {

  private String titulo;

  public String palavrasChave;

  public String abstract;

  public String tipoDePublicacao;

  public int ano;

  public int numDownloads;

  public int numViewspDia;

  public int numLikespDia;

    public List<Publicacao> publicacao;
    /**
    * 
    *
   */
  public List<Autor> autores;
    public LocalPublicacao publicacao;

  public void adicionarArtigo( titulo,  palavrasChave,  abstract,  tipoDePublicacao,  ano,  numDownloads,  numViewspDia,  numLikespDia) {
  }

  public void removerArtigo( titulo,  palavrasChave,  abstract,  tipoDePublicacao,  ano,  numDownloads,  numViewspDia,  numLikespDia) {
  }

  public void atualizarArtigo( titulo,  palavrasChave,  abstract,  tipoDePublicacao,  ano,  numDownloads,  numViewspDia,  numLikespDia) {
  }

}