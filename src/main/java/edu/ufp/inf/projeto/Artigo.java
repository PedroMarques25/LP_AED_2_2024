package edu.ufp.inf.projeto;

import java.util.ArrayList;
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
  public List<Autor> autor;
  public List<Artigo> artigos = new ArrayList<>();

   public List<Journal> jornais = new ArrayList<>();


  public void adicionarArtigo(String titulo, String palavrasChave, String absTract, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia,  int numLikespDia) {
  }

  public void removerArtigo (String titulo, String palavrasChave, String absTract, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia,  int numLikespDia){
  }

  public void atualizarArtigo( String titulo, String palavrasChave, String absTract, String tipoDePublicacao, int ano, int numDownloads, int numViewspDia,  int numLikespDia) {
  }

}
