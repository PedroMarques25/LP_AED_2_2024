package edu.ufp.inf.projeto;


import edu.ufp.inf.lp2._0_videoclub.Movie;

import java.util.ArrayList;
import java.util.List;


public class Autor {

  private String nome;

  public String nome_curto;

  public String filiacao;

  public Integer ORCID;

  public Integer ciencia_ID;

  public Integer googleScholar_ID;

  public Integer scopusAuthor_ID;

  public Autor(String nome, String nome_curto,String filiacao,Integer ORCID,Integer ciencia_ID,Integer googleScholar_ID,Integer scopusAuthor_ID){
    this.nome=nome;
    this.nome_curto=nome_curto;
    this.filiacao=filiacao;
    this.ORCID=ORCID;
    this.ciencia_ID=ciencia_ID;
    this.googleScholar_ID=googleScholar_ID;
    this.scopusAuthor_ID=scopusAuthor_ID;
  }
  public List<Autor> autores = new ArrayList<>();
    //public List<Publicacao> publicacao;
    /**
    * 
    *
   */
  public void adicionarAutor(Autor autor) {
    autores.add(autor);
  }

  public void removerAutor(Autor autor) {
    autores.remove(autor);
  }

  public void atualizarAutor(String nome, String nome_curto, String filiacao, int ORCID, int ciencia_ID, int googleScholar_ID, int scopusAuthor_ID,int key) {

          autores.get(key).nome=nome;
          autores.get(key).nome_curto=nome_curto;
          autores.get(key).filiacao=filiacao;
          autores.get(key).ORCID=ORCID;
          autores.get(key).ciencia_ID=ciencia_ID;
          autores.get(key).googleScholar_ID=googleScholar_ID;
          autores.get(key).scopusAuthor_ID=scopusAuthor_ID;
  }

}
