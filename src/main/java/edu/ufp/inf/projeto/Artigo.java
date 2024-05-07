package edu.ufp.inf.projeto;

import java.util.List;


public class Artigo {

  private String titulo;

  public String palavrasChave;

  //public String abstract;

  public String tipoDePublicacao;

  public int ano;

  public int numDownloads;

  public int numViewspDia;

  public int numLikespDia;

    //public ArrayList<Publicacao> publicacao;
    /**
    * 
    *
   */
  public List<Autor> autores;


  public void adicionarArtigo(String titulo, String palavrasChave, String absTract, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia,  int numLikespDia) {
  }

  public void removerArtigo (String titulo, String palavrasChave, String absTract, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia,  int numLikespDia){
  }

  public void atualizarArtigo( String titulo, String palavrasChave, String absTract, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia,  int numLikespDia) {
  }

}