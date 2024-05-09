package edu.ufp.inf.projeto;

import java.util.ArrayList;
import java.util.List;


public class Artigo {

  private String titulo;

  public String palavrasChave;


  public String tipoDePublicacao;

  public int ano;

  public int numDownloads;

  public int numViewspDia;

  public int numLikespDia;
  public Artigo(Autor autor,String titulo,String palavrasChave,String tipoDePublicacao,
                int ano,int numDownloads,int numViewspDia,int numLikespDia){

    this.autor= (List<Autor>) autor;
    this.titulo=titulo;
    this.palavrasChave=palavrasChave;
    this.tipoDePublicacao=tipoDePublicacao;
    this.ano=ano;
    this.numDownloads=numDownloads;
    this.numLikespDia=numLikespDia;
    this.numViewspDia=numViewspDia;

  }

    //public ArrayList<Publicacao> publicacao;
    /**
    * 
    *
   */
  public List<Autor> autor;
  public List<Artigo> artigos = new ArrayList<>();

   public List<Journal> jornais = new ArrayList<>();


  public void adicionarArtigo(Artigo artigo) {
    artigos.add(artigo);
  }

  public void removerArtigo (Artigo artigo){
    artigos.remove(artigo);
  }

  public void atualizarArtigo(Autor autor, String titulo, String palavrasChave,
                              String tipoDePublicacao, int ano, int numDownloads, int numViewspDia, int numLikespDia,int key) {
    artigos.get(key).autor= (List<Autor>) autor;
    artigos.get(key).titulo=titulo;
    artigos.get(key).palavrasChave=palavrasChave;
    artigos.get(key).tipoDePublicacao=tipoDePublicacao;
    artigos.get(key).ano=ano;
    artigos.get(key).numDownloads=numDownloads;
    artigos.get(key).numViewspDia=numViewspDia;
    artigos.get(key).numLikespDia=numLikespDia;
  }

}
